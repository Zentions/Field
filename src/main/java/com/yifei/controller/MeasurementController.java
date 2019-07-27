package com.yifei.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yifei.bean.Measurement;
import com.yifei.bean.Msg;
import com.yifei.bean.Sensor;
import com.yifei.service.MeasurementService;

@Controller
public class MeasurementController {

	@Autowired
	MeasurementService measurementService;
	
	@ResponseBody
	@RequestMapping("/getRecForHours")
	public Msg getMeasurementInfo(@RequestParam(value="nodeid")Integer nodeid) {
		List<Measurement> list = measurementService.getMeasurementInfo(nodeid);
		return Msg.success().add("records", list);
	}
	
	@ResponseBody
	@RequestMapping("/getLastRec")
	public Msg getLastRecord(@RequestParam(value="nodeid")Integer nodeid) {
		Measurement measurement = measurementService.getLastMeasurement(nodeid);
		if(measurement==null) return Msg.failure();
		else return Msg.success().add("record", measurement);
	}
	
	@ResponseBody
	@RequestMapping(value="/addMeasurement",method = RequestMethod.POST)
	public Msg addMeasurement(Measurement measurement) {
		Date date = new Date();
		measurement.setDate(date);
		System.out.println(measurement);
		int code = measurementService.insertMeasurement(measurement);
		if(code==0) {
			return Msg.failure();
		}else {
			return Msg.success().add("code", Integer.valueOf(code));
		}
	}
}
