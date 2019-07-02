package com.lqr.HWspringboot.service;

import java.util.List;

import com.lqr.HWspringboot.entity.User;

public interface UserService {
    List<User> selectAll();
    User getUserById(Integer id);
}
