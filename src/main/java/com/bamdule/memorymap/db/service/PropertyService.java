package com.bamdule.memorymap.db.service;

import com.bamdule.memorymap.model.entity.Property;
import java.util.List;

/**
 *
 * @author MW
 */
public interface PropertyService {

    public List<Property> getListProperty(String type);

}
