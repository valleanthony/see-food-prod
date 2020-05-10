package com.anthonyvalle.seefoodprod.Controllers;

import com.anthonyvalle.seefoodprod.Models.User;
import com.anthonyvalle.seefoodprod.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserByID(@Valid @PathVariable Long id) throws UserPrincipalNotFoundException {
       return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid User user)throws ValidationException {
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, User user) throws UserPrincipalNotFoundException {
        return new ResponseEntity<User>(userService.updateUser(id,user),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) throws EntityNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }





}
