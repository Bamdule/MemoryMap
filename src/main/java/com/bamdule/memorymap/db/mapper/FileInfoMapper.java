package com.bamdule.memorymap.db.mapper;

import com.bamdule.memorymap.model.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author MW
 */
@Mapper
public interface FileInfoMapper {

    public int getFileInfoNextSeq();

    public FileInfo getFileInfo(Integer id);

    public void saveFile(FileInfo fileInfo);

    public void deleteFile(Integer id);

}
