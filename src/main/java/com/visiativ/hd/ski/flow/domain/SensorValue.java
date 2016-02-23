package com.visiativ.hd.ski.flow.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by visiativ on 23/02/16.
 */
public class SensorValue {

    @Id
    private String id;
    private String skiLiftId;
    private Integer state;
    private Integer priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkiLiftId() {
        return skiLiftId;
    }

    public void setSkiLiftId(String skiLiftId) {
        this.skiLiftId = skiLiftId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
