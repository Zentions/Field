package com.yifei.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yifei.bean.Msg;
import com.yifei.bean.Sensor;
import com.yifei.bean.User;
import com.yifei.bean.statisticForSensor;
import com.yifei.service.SensorService;

@Controller
public class SensorController {

	@Autowired
	private SensorService sensorService;
	
	@ResponseBody
	@RequestMapping(value="/addSensorNP")
	public Msg addSensorNonePhone() {
		Sensor sensor = new Sensor();
		System.out.println(sensor);
		int code = sensorService.insertSensorNonePhone(sensor);
		if(code==0) {
			return Msg.failure();
		}else {
			return Msg.success().add("code", Integer.valueOf(code));
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updateSensor",method=RequestMethod.POST)
	public Msg updateSensor(Sensor sensor) {
		int code = sensorService.updateSensorById(sensor);
		if(code==0) {
			return Msg.failure();
		}else {
			return Msg.success().add("code", Integer.valueOf(code));
		}
	}
	
	@ResponseBody
	@RequestMapping("/getSensors")
	public Msg getSensorsByPhone(@RequestParam(value="phone")String phone) {
		List<Sensor> list = sensorService.getSensorsByPhone(phone);
		return Msg.success().add("sensors", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/delSensor",method=RequestMethod.POST)
	public Msg delSensorByID(Integer id) {
		int code = sensorService.deleteSensorByID(id);
		if(code ==0) return Msg.failure();
		else return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/delSensors",method=RequestMethod.POST)
	public Msg delAllSensor(String phone) {
		System.out.println(phone);
		int code = sensorService.deleteSensorByPhone(phone);
		System.out.println(code);
		if(code ==0) return Msg.failure();
		else return Msg.success();
	}
	@ResponseBody
	@RequestMapping(value="/statistic")
	public Msg getStatistic() {
		statisticForSensor statistic = sensorService.getStatistic();
		return Msg.success().add("info", statistic);
	}
	
}
