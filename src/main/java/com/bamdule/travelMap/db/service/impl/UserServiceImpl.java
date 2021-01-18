package com.bamdule.travelMap.db.service.impl;

import com.bamdule.travelMap.db.dao.UserMapper;
import com.bamdule.travelMap.db.service.UserService;
import com.bamdule.travelMap.model.User;
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
