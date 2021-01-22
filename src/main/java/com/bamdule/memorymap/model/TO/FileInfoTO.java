package com.bamdule.memorymap.model.TO;

import com.bamdule.memorymap.model.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MW
 */
public class FileInfoTO extends FileInfo {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileInfoTO{" + "file=" + file + '}' + super.toString();
    }

}
