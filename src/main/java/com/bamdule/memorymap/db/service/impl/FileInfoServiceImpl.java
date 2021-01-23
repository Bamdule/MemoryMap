package com.bamdule.memorymap.db.service.impl;

import com.bamdule.memorymap.db.mapper.FileInfoMapper;
import com.bamdule.memorymap.db.service.FileInfoService;
import com.bamdule.memorymap.file.S3Service;
import com.bamdule.memorymap.model.TO.FileInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private S3Service s3Service;

    @Override
    public void saveFile(FileInfoTO fileInfoTO) {

        switch (fileInfoTO.getStatus()) {
            case CREATE:
                fileInfoTO.setId(fileInfoMapper.getFileInfoNextSeq());
                s3Service.upload(fileInfoTO);
                fileInfoMapper.saveFile(fileInfoTO);
                break;
            case UPDATE:
                s3Service.delete(fileInfoMapper.getFileInfo(fileInfoTO.getId()).getPath());
                s3Service.upload(fileInfoTO);
                fileInfoMapper.saveFile(fileInfoTO);
                break;
            case DELETE:
                s3Service.delete(fileInfoMapper.getFileInfo(fileInfoTO.getId()).getPath());
                fileInfoMapper.deleteFile(fileInfoTO.getId());
                break;
            case NONE:
                break;
        }
    }
}
