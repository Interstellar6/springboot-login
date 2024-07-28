package com.interstellar.controller;

import com.interstellar.bean.Result;
import com.interstellar.bean.User;
import com.interstellar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public Result regist(User user) {
        return userService.regist(user);
    }

    @PostMapping("/login")
    public Result login(User user) {
        return userService.login(user);
    }
}

