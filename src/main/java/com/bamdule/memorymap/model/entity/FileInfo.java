package com.bamdule.memorymap.model.entity;

import java.time.LocalDateTime;

/**
 *
 * @author MW
 */
public class FileInfo {

    private Integer id;
    private String orgFilename;
    private String path;
    private String contentType;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgFilename() {
        return orgFilename;
    }

    public void setOrgFilename(String orgFilename) {
        this.orgFilename = orgFilename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    public LocalDateTime getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDateTime updateDt) {
        this.updateDt = updateDt;
    }

    @Override
    public String toString() {
        return "FileInfo{" + "id=" + id + ", orgFilename=" + orgFilename + ", path=" + path + ", contentType=" + contentType + ", createDt=" + createDt + ", updateDt=" + updateDt + '}';
    }

}
