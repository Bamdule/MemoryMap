package com.bamdule.memorymap.controller;

import com.bamdule.memorymap.db.service.UserService;
import com.bamdule.memorymap.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/")
    public String homeView() {
        logger.info("[MYTEST] homeView");
        return "page/main";
    }
}
