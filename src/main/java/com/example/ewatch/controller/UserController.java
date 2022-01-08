package com.example.ewatch.controller;

import com.example.ewatch.model.User;
import com.example.ewatch.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @PostMapping("")
    public void add(@RequestBody User user){
        userService.add(user);
    }


}
