package com.anthonyvalle.seefoodprod.Services.Impl;

import com.anthonyvalle.seefoodprod.Models.User;
import com.anthonyvalle.seefoodprod.Repos.UserRepo;
import com.anthonyvalle.seefoodprod.Services.Interfaces.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
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
    public User getUser(Long id) {

        if (!userRepo.findById(id).isPresent()){
            throw new EntityNotFoundException("User not found");
        } else {
            return userRepo.getOne(id);

        }
    }

    @Override
    public User createUser(User user) {
        if (user == null){
            throw new ValidationException();
        }else
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
       }else{
           throw new EntityNotFoundException();
       }
       return user;
    }


    @Override
    public void deleteUser(Long id) {
        if (userRepo.findById(id).isPresent()){
            try {
                userRepo.deleteById(id);
            }catch (Exception e){
                e.printStackTrace();

            }
        }else{
            throw new EntityNotFoundException();
        }

    }

}
