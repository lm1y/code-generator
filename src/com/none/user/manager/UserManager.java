package com.none.user.manager;

import com.none.user.persistence.dao.UserDao;
import com.none.user.persistence.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
* @author xx
* @date 2021/04/19
*/
@Component
public class UserManager {

@Resource
private UserDao userDao;

public User findUserById(Long userId) {
return userDao.findUserById(userId);
}
}
