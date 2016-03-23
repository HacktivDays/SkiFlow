package com.visiativ.hd.ski.flow.rest;

import com.visiativ.hd.ski.flow.domain.SensorValue;
import com.visiativ.hd.ski.flow.repositories.SensorValueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by visiativ on 23/02/16.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    private static final Map<Integer, Integer> FORCED = new ConcurrentHashMap<>();
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
        SensorValue slid0 = this.sensorValueRepository.findFirstBySkiLiftIdOrderByDateDesc(0);
        SensorValue slid1 = this.sensorValueRepository.findFirstBySkiLiftIdOrderByDateDesc(1);
        SensorValue slid2 = this.sensorValueRepository.findFirstBySkiLiftIdOrderByDateDesc(2);


        //SensorValue slid2 = this.sensorValueRepository.findOneBySkiLiftIdOrderByDateDesc(0);

        StringBuilder response = new StringBuilder("");
        response.append(slid0.getState());
        response.append(slid1.getState());
        response.append(Math.max(slid0.getState(), slid1.getState()));
        response.append(slid2.getState());
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

        if (value.getPriority() == 1) {
            FORCED.put(value.getSkiLiftId(), value.getState());
        } else if (FORCED.get(value.getSkiLiftId()) != null && FORCED.get(value.getSkiLiftId()) != 3) {
            value.setState(FORCED.get(value.getSkiLiftId()));
        }

        value.setDate(new Date());

        System.out.println(value.toString());

        sensorValueRepository.insert(value);
        if (value.getPriority() == 1) {
            FORCED.put(value.getSkiLiftId(), value.getState());
        }
    }
}
