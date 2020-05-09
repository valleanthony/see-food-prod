package com.anthonyvalle.seefoodprod.Controllers;

import com.anthonyvalle.seefoodprod.Models.User;
import com.anthonyvalle.seefoodprod.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> getUserByID(@Valid @PathVariable Long id){
       // return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
        // TODO: 5/9/20 implement
        return  null;
    }



}
