package com.none.user.persistence.dao;

import com.none.user.persistence.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xx
* @date 2021/04/19
*/
@Mapper
public interface UserDao {

User findUserById(Long id);

}