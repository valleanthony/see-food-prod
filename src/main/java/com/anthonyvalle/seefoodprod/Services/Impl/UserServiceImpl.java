package com.anthonyvalle.seefoodprod.Services.Impl;

import com.anthonyvalle.seefoodprod.Models.User;
import com.anthonyvalle.seefoodprod.Repos.UserRepo;
import com.anthonyvalle.seefoodprod.Services.Interfaces.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Long id) throws UserPrincipalNotFoundException {
       if (userRepo.findById(id).isPresent()){
           try{
                return  userRepo.getOne(id);
           }catch (Exception e){
               e.printStackTrace();
           }
       }else
           throw new UserPrincipalNotFoundException("User not found");
       return null;
    }

    @Override
    public User createUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public User updateUser(Long id, User user) {
       if (userRepo.findById(id).isPresent()){
           try {
               User dbUser = userRepo.getOne(id);
               BeanUtils.copyProperties(user,dbUser,"id");
               return userRepo.saveAndFlush(dbUser);
           }catch (Exception e){
              e.printStackTrace();

           }
       }
       return user;
    }


    @Override
    public void deleteUser(Long id) {
         userRepo.deleteById(id);
    }

}
