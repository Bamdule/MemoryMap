package com.bamdule.memorymap.db.mapper;

import com.bamdule.memorymap.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author MW
 */
@Mapper
public interface UserMapper {

    public void saveUser(User user);

}
