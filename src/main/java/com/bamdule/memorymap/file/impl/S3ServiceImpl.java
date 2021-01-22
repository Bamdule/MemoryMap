package com.bamdule.memorymap.file.impl;

import com.bamdule.memorymap.model.TO.FileInfoTO;
import org.springframework.stereotype.Service;
import com.bamdule.memorymap.file.S3Service;

/**
 *
 * @author MW
 */
@Service
public class S3ServiceImpl implements S3Service {

    @Override
    public void upload(FileInfoTO fileInfoTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
