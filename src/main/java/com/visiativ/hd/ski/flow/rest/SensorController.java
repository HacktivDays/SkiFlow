package com.visiativ.hd.ski.flow.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by visiativ on 23/02/16.
 */
@Controller
@RequestMapping("/data")
public class SensorController {

    protected static final class STATUS{public static final int GREEN = 0;public static final int ORANGE = 0;public static final int RED = 2;}

    @RequestMapping(value = "/{panelId}", method = RequestMethod.GET)
    @ResponseBody
    public int home(@PathVariable("panelId") int panelId) {
        switch (panelId) {
            case 1:
                return STATUS.GREEN;
            case 2:
                return STATUS.ORANGE;
            default:
                return STATUS.GREEN;
        }
    }
}
