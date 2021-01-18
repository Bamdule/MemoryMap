package com.bamdule.travelMap.db.dao;

import com.bamdule.travelMap.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author MW
 */
@Mapper
public interface UserMapper {

    public void saveUser(User user);

}
