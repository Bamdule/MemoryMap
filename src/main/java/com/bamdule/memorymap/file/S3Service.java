package com.bamdule.memorymap.file;

import com.bamdule.memorymap.model.TO.FileInfoTO;

/**
 *
 * @author MW
 */
public interface S3Service {

    public void upload(FileInfoTO fileInfoTO);

    public void delete(String key);

}
