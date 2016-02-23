package com.visiativ.hd.ski.flow.rest;

import com.visiativ.hd.ski.flow.domain.SensorValue;
import com.visiativ.hd.ski.flow.repositories.SensorValueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by visiativ on 23/02/16.
 */
@Controller
@RequestMapping("/data")
public class SensorController {

    @Resource
    SensorValueRepository sensorValueRepository;

    @RequestMapping(value = "/{panelId}", method = RequestMethod.GET)
    @ResponseBody
    public int home(@PathVariable("panelId") int panelId) {
        SensorValue sensorValue = new SensorValue();

        sensorValue.setPriority(0);
        sensorValue.setSkiLiftId("17");
        sensorValue.setState(3);


        sensorValueRepository.insert(sensorValue);
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

    protected static final class STATUS {
        public static final int GREEN = 0;
        public static final int ORANGE = 1;
        public static final int RED = 2;
    }

}
