package com.visiativ.hd.ski.flow.rest;

import com.visiativ.hd.ski.flow.domain.SensorValue;
import com.visiativ.hd.ski.flow.repositories.SensorValueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by visiativ on 23/02/16.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Resource
    SensorValueRepository sensorValueRepository;

    /**
     * The LED display's arduino has to call this method to know what color display
     *
     * @param panelId
     * @return 0/1/2 (Green/orange/red)
     */
    @RequestMapping(value = "/{panelId}", method = RequestMethod.GET)
    @ResponseBody
    public int getSkiLiftState(@PathVariable("panelId") int panelId) {

        //Iterable<SensorValue> values = this.sensorValueRepository.findBySkiLiftId(panelId);

        switch (panelId) {
            case 1:
                return STATUS.GREEN;
            case 2:
                return STATUS.ORANGE;
            case 3:
                return STATUS.RED;
            default:
                return STATUS.GREEN;
        }
    }

    /**
     * Put data to mongo
     *
     * @param value
     */
    @RequestMapping(method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void putState(@RequestBody SensorValue value) {
        value.setDate(new Date());
        sensorValueRepository.insert(value);
    }

    protected static final class STATUS {
        public static final int GREEN = 0;
        public static final int ORANGE = 1;
        public static final int RED = 2;
    }
}
