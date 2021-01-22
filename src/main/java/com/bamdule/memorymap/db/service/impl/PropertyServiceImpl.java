package com.bamdule.memorymap.db.service.impl;

import com.bamdule.memorymap.db.mapper.PropertyMapper;
import com.bamdule.memorymap.db.service.PropertyService;
import com.bamdule.memorymap.model.entity.Property;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<Property> getListProperty(String type) {
        return propertyMapper.getListProperty(type);
    }

}
