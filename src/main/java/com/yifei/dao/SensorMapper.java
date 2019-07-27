package com.yifei.dao;

import com.yifei.bean.Sensor;
import com.yifei.bean.SensorExample;
import com.yifei.bean.statisticForSensor;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorMapper {
    long countByExample(SensorExample example);

    int deleteByExample(SensorExample example);

    int deleteByPrimaryKey(Integer sensorid);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    List<Sensor> selectByExample(SensorExample example);

    Sensor selectByPrimaryKey(Integer sensorid);

    int updateByExampleSelective(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByExample(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
    
    statisticForSensor selectStaticForSensor();
}