package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Device;
import com.example.model.Devices;

@Controller

public class MainController {
	
	@Autowired
	private RestTemplate rs;
	@RequestMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@RequestMapping("/samsung")
	public ModelAndView samsung() {
		
		ModelAndView mv=new ModelAndView("/samsung");
//		rs=new RestTemplate();
		Devices deviceList=rs.getForObject("http://Samsung/samsung", Devices.class);
//		Devices deviceList= new Devices(myList, "samsung");
		mv.addObject("samsung", deviceList);
		return mv;
	}
	
	@RequestMapping("/apple")
	public ModelAndView apple() {
		
		ModelAndView mv=new ModelAndView("/apple");
		Device d1=new Device(1, "Iphone 16", "Smart phone");
		Device d2=new Device(2, "Iphone 16 plus", "Smart phone");
		Device d3=new Device(3, "Iphone 16 pro", "Smart phone");
		Device d4=new Device(4, "Iphone 16 pro max", "bad choice Smart phone");
		ArrayList<Device> myList = new ArrayList();
		myList.add(d1);
		myList.add(d2);
		myList.add(d3);
		myList.add(d4);
		Devices deviceList= new Devices(myList, "apple");
		mv.addObject("apple", deviceList);
		return mv;
	}

	


}