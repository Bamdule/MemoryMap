package com.bamdule.memorymap.file.impl;

import com.bamdule.memorymap.config.ServerConfig;
import com.bamdule.memorymap.db.service.FileInfoService;
import com.bamdule.memorymap.model.TO.FileInfoTO;
import org.springframework.stereotype.Service;
import com.bamdule.memorymap.file.S3Service;
import com.bamdule.memorymap.util.aws.AwsS3;
import java.time.LocalDate;
import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MW
 */
@Service
public class S3ServiceImpl implements S3Service {

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private AwsS3 awsS3;

    @Override
    public void upload(FileInfoTO fileInfoTO) {
        MultipartFile multipartFile = fileInfoTO.getFile();

        fileInfoTO.setOrgFilename(multipartFile.getOriginalFilename());
        fileInfoTO.setContentType(multipartFile.getContentType());
        fileInfoTO.setPath(createPath(fileInfoTO));

        awsS3.upload(multipartFile, fileInfoTO.getPath());
    }

    @Override
    public void delete(String key) {
        awsS3.delete(key);
    }

    public String createPath(FileInfoTO fileInfoTO) {
        LocalDate now = LocalDate.now();
        String tableName = fileInfoTO.getTableName();
        String orgFilename = fileInfoTO.getOrgFilename();
        Integer id = fileInfoTO.getId();

        return new StringBuilder()
                .append(serverConfig.getConfig("aws_s3_resource_dir"))
                .append("/")
                .append(Strings.isBlank(tableName) ? "common" : tableName)
                .append("/")
                .append(now.getYear())
                .append("/")
                .append(now.getMonthValue())
                .append("/")
                .append(now.getDayOfMonth())
                .append("/")
                .append(RandomStringUtils.randomAlphanumeric(31))
                .append(id)
                .append(orgFilename.substring(orgFilename.lastIndexOf("."), orgFilename.length()))
                .toString();
    }
}
