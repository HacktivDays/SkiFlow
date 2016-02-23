package com.visiativ.hd.ski.flow.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by visiativ on 23/02/16.
 */
@Controller
@RequestMapping("/sensor")
public class SensorController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
