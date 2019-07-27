package com.yifei.bean;

import java.util.Date;

public class Measurement {
    private Integer id;

    private String temperture;

    private String light;

    private String humidity;

    private Date date;

    private Integer nodeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperture() {
        return temperture;
    }

    public void setTemperture(String temperture) {
        this.temperture = temperture == null ? null : temperture.trim();
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light == null ? null : light.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }
}