package com.bamdule.memorymap.db.mapper;

import com.bamdule.memorymap.model.entity.Property;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author MW
 */
@Mapper
public interface PropertyMapper {

    public List<Property> getListProperty(String type);

}
