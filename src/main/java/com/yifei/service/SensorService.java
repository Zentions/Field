package com.yifei.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yifei.bean.Sensor;
import com.yifei.bean.SensorExample;
import com.yifei.bean.SensorExample.Criteria;
import com.yifei.bean.User;
import com.yifei.bean.statisticForSensor;
import com.yifei.dao.SensorMapper;
import com.yifei.dao.UserMapper;

@Service
public class SensorService {
	
	@Autowired
	SensorMapper sensorMapper;
	
    public int insertSensorNonePhone(Sensor sensor) {
    	int code=1;
    	try {
    		code = sensorMapper.insert(sensor);
    		
		} catch (Exception e) {
			code = 0;
		}
    	
    	System.out.println("code="+code);
    	return code;
    			
	}
    
    public int updateSensorById(Sensor sensor) {
    	int code=1;
    	try {
    		code= sensorMapper.updateByPrimaryKeySelective(sensor);
    		
		} catch (Exception e) {
			code = 0;
		}
    	
    	System.out.println("code="+code);
    	return code;
    			
	}
    
//    public int getMaxSensorid() {
//    	return  sensorMapper.
//    }
    public List<Sensor> getSensorsByPhone(String phone){
    	SensorExample example = new SensorExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andPhonenumEqualTo(phone);
    	return sensorMapper.selectByExample(example);
    }
    
    public int deleteSensorByID(Integer id) {
    	SensorExample example = new SensorExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andSensoridEqualTo(id);
    	return sensorMapper.deleteByExample(example);
	}
    public int deleteSensorByPhone(String phone) {
    	SensorExample example = new SensorExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andPhonenumEqualTo(phone);
    	return sensorMapper.deleteByExample(example);
	}
    
    public statisticForSensor getStatistic() {
		return sensorMapper.selectStaticForSensor();
	}
}
