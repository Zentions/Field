package com.yifei.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yifei.bean.Measurement;
import com.yifei.bean.MeasurementExample;
import com.yifei.bean.MeasurementExample.Criteria;
import com.yifei.dao.MeasurementMapper;

@Service
public class MeasurementService {

	private int hours = 6;
	@Autowired
	private MeasurementMapper measurementMapper;
	
	public List<Measurement> getMeasurementInfo(Integer nodeid) {
    	Date currentDate = new Date();
    	Date HoursBefore = new Date(currentDate.getTime()-hours*60*60000);
    	MeasurementExample example = new MeasurementExample();
    	Criteria criteria = example.createCriteria();
    	criteria.andNodeidEqualTo(nodeid);
    	criteria.andDateBetween(HoursBefore, currentDate);
    	return measurementMapper.selectByExample(example);
    }

    public Measurement getLastMeasurement(Integer nodeid) {
    	System.out.println(nodeid);
    	return measurementMapper.selectByNodeIDForNewest(nodeid);
		
	}
    
    
    public int insertMeasurement(Measurement measurement) {
    	int code=1;
    	try {
    		code = measurementMapper.insert(measurement);
    		
		} catch (Exception e) {
			code = 0;
		}
    	
    	System.out.println("code="+code);
    	return code;
    			
	}
}
