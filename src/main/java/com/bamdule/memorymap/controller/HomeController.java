package com.bamdule.memorymap.controller;

import com.bamdule.memorymap.db.service.FileInfoService;
import com.bamdule.memorymap.db.service.UserService;
import com.bamdule.memorymap.model.TO.FileFormTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private FileInfoService fileInfoService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String homeView() {
        logger.info("[MYTEST] homeView");
        return "page/home/home";
    }

    @PostMapping(value = "/saveFile")
    @ResponseBody
    public String saveFileTest(FileFormTO fileFormTO) {

        fileFormTO.getFiles().forEach(file -> {
            logger.info("[MYTEST] {} ", file.getFile().getOriginalFilename());
            file.setTableName("place");
            fileInfoService.saveFile(file);
        });

        return "good";

    }
}
