package com.yifei.bean;

public class Sensor {
    private Integer sensorid;

    private String node;

    private String loc;

    private String phonenum;

    public Integer getSensorid() {
        return sensorid;
    }

    public void setSensorid(Integer sensorid) {
        this.sensorid = sensorid;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }
}