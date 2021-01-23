package com.bamdule.memorymap.model.TO;

import com.bamdule.memorymap.model.entity.FileInfo;
import com.bamdule.memorymap.model.enums.FileStatus;
import java.util.Objects;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MW
 */
public class FileInfoTO extends FileInfo {

    private MultipartFile file;

    private String deleteYN = "N";
    
    private String tableName;
    
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDeleteYN() {
        return deleteYN;
    }

    public void setDeleteYN(String deleteYN) {
        this.deleteYN = deleteYN;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public FileStatus getStatus() {

        if (deleteYN.equals("Y")) {
            if (Objects.isNull(getId())) {
                return FileStatus.NONE;
            } else {
                return FileStatus.DELETE;
            }
        } else if (Objects.nonNull(file)) {
            if (Objects.isNull(getId())) {
                return FileStatus.CREATE;
            } else {
                return FileStatus.UPDATE;
            }
        } else {
            return FileStatus.NONE;
        }
    }

    @Override
    public String toString() {
        return "FileInfoTO{" + "file=" + file + ", deleteYN=" + deleteYN + '}' + super.toString();
    }

}
