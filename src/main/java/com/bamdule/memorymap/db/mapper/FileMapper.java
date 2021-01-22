package com.bamdule.memorymap.db.mapper;

import com.bamdule.memorymap.model.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author MW
 */
@Mapper
public interface FileMapper {

    public void saveFile(FileInfo fileInfo);

    public void deleteFile(String path);

}
