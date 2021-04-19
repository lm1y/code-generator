package com.none.user.controller;

import  com.none.user.persistence.entity.User;
import  com.none.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author xx
* @date 2021/04/19
*/
@RestController
@RequestMapping("/users")
public class UserController {

@Resource
private UserService userService;

@GetMapping("/{userId}")
public User findUserById(@PathVariable Long userId) {
return userService.findUserById(userId);
}

}
