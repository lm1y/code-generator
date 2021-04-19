package com.none.user.service.user;

import com.none.user.manager.UserManager;
import com.none.user.persistence.entity.User;
import com.none.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author xx
* @date 2021/04/19
*/
@Service
public class UserServiceImpl implements UserService {

@Resource
private UserManager userManager;

@Override
public User findUserById(Long userId) {
return userManager.findUserById(userId);
}
}
