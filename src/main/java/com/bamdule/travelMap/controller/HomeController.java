package com.bamdule.travelMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping(value = "/")
    public String homeView() {
        return "home";
    }
}