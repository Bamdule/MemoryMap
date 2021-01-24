package com.bamdule.memorymap.db.service;

import com.bamdule.memorymap.model.VO.UserVO;
import com.bamdule.memorymap.model.entity.User;

/**
 *
 * @author MW
 */
public interface UserService {

    public void saveUser(User user);

    public UserVO getUserByName(String userName);

}
