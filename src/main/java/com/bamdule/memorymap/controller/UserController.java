package com.bamdule.memorymap.controller;

import com.bamdule.memorymap.db.service.UserService;
import com.bamdule.memorymap.model.VO.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String homeView() {
        logger.info("[MYTEST] homeView");
        return "page/user/user";
    }

    @GetMapping(value = "/{userName}")
    public ModelAndView userProfileView(
            @PathVariable(name = "userName") String userName
    ) {
        ModelAndView modelAndView = new ModelAndView("page/user/user-profile-view");
        UserVO userVO = userService.getUserByName(userName);
        logger.info("[MYTEST] userProfileView : {} {}", userName, userVO);

        modelAndView.addObject("user", userVO);

        return modelAndView;
    }
}
