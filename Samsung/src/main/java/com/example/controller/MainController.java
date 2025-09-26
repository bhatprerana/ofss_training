package com.example.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Device;
import com.example.model.Devices;

@RestController

public class MainController {
	
	@RequestMapping("/home")
	public String home() {
		return "home.html";
	}
	
//	@RequestMapping("/samsung")
//	public ModelAndView samsung() {
//		
//		ModelAndView mv=new ModelAndView("/samsung");
//		Device d1=new Device(1, "Galaxy Samsung23", "Smart phone");
//		Device d2=new Device(2, "Galaxy Samsung24", "Smart phone");
//		Device d3=new Device(3, "Galaxy Samsung25", "Smart phone");
//		Device d4=new Device(4, "Galaxy Samsung23Ultra", "bad choice Smart phone");
//		ArrayList<Device> myList = new ArrayList();
//		myList.add(d1);
//		myList.add(d2);
//		myList.add(d3);
//		myList.add(d4);
//		Devices deviceList= new Devices(myList, "samsung");
//		mv.addObject("samsung", deviceList);
//		return mv;
//	}
	@RequestMapping("/samsung")
	public Devices samsung() {
		
		ModelAndView mv=new ModelAndView("/samsung");
		Device d1=new Device(1, "Galaxy Samsung23", "Smart phone-from1");
		Device d2=new Device(2, "Galaxy Samsung24", "Smart phone with AI-from1");
		Device d3=new Device(3, "Galaxy Samsung25", "Smart phone bad choice-from1");
		Device d4=new Device(4, "Galaxy Samsung23Ultra", "ultra smart phone-from1");
		ArrayList<Device> myList = new ArrayList();
		myList.add(d1);
		myList.add(d2);
		myList.add(d3);
		myList.add(d4);
		Devices deviceList= new Devices(myList, "samsung");
		
		return deviceList;
	}
	


	


}