package com.anthonyvalle.seefoodprod.Services.Interfaces;

import com.anthonyvalle.seefoodprod.Models.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(Long id) throws UserPrincipalNotFoundException;
    User createUser(User user);
    User updateUser(Long id, User user) throws UserPrincipalNotFoundException;
    void deleteUser(Long id);



}
