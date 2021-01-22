package com.bamdule.memorymap.db.service.impl;

import com.bamdule.memorymap.db.mapper.UserMapper;
import com.bamdule.memorymap.db.service.UserService;
import com.bamdule.memorymap.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

}
