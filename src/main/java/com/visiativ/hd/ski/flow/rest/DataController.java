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
     * @return 0/1/2 (Green/orange/red)
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getSkiLiftsStates() {

        // Iterable<SensorValue> values = this.sensorValueRepository.findBySkiLiftId(panelId);
        //values.forEach(sensorValue -> System.out.println(sensorValue.getId() + " / " + sensorValue.getDate() + " / "+ sensorValue.getPriority() + " / " +sensorValue.getSkiLiftId() + " / " +sensorValue.getState()));

        StringBuilder response = new StringBuilder("");
        response.append(STATUS.GREEN);
        response.append(STATUS.RED);
        response.append(STATUS.ORANGE);
        response.append(STATUS.GREEN);
        return response.toString();
    }

    /**
     * Put data to mongo
     *
     * @param value
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void putState(@RequestBody SensorValue value) {
        value.setDate(new Date());
        sensorValueRepository.insert(value);
    }

    protected static final class STATUS {
        public static final int GREEN = 3;
        public static final int ORANGE = 2;
        public static final int RED = 1;
    }
}
