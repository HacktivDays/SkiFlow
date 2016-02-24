package com.visiativ.hd.ski.flow.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by visiativ on 23/02/16.
 */
public class SensorValue {

    @Id
    private String id;
    private Integer skiLiftId;
    private Integer state;
    private Integer priority;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSkiLiftId() {
        return skiLiftId;
    }

    public void setSkiLiftId(Integer skiLiftId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
