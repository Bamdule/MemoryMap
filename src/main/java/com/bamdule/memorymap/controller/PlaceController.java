package com.bamdule.memorymap.controller;

import com.bamdule.memorymap.model.entity.place.PlaceFormTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @ResponseBody
    @PostMapping(value = "/edit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editPlace(PlaceFormTO placeFormTO) {
        logger.info("{} {}", placeFormTO, placeFormTO.getFiles().size());
    }
}
