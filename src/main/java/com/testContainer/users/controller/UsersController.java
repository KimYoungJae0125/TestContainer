package com.testContainer.users.controller;

import com.testContainer.users.model.entity.Users;
import com.testContainer.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping
    void save(@RequestBody Users users) {
        usersService.save(users);
    }

}
