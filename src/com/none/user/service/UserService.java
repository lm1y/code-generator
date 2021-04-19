package com.none.user.service;

import com.none.user.persistence.entity.User;

/**
* @author xx
* @date 2021/04/19
*/
public interface UserService {

User findUserById(Long userId);
}
