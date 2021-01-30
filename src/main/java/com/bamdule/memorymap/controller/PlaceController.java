package com.bamdule.memorymap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MW
 */
@Controller
@RequestMapping(value = "/place")
public class PlaceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/edit")
    public String placeEditView() {
        logger.info("[MYTEST] PlaceEditView");
        return "page/place/place-edit-view";
    }
}
