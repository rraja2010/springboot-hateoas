package com.dataSource.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dataSource.dao.SpringBootDAO;
import com.dataSource.rowmapper.Car;
import com.example.resthateoas.Greeting;
import com.websystique.springboot.util.CustomErrorType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CarSearchController {
	
	public static final Logger logger = LoggerFactory.getLogger(CarSearchController.class);
	@Autowired
	private SpringBootDAO  dao;
	


	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
		@RequestParam(value = "name", defaultValue = "World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(CarSearchController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
	// -------------------Retrieve All Cars---------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/allCarList")
	@ResponseBody
	public List<Car> getCarInfo(){
		
		logger.info("com.dataSource.controller.CarSearchController@getCarInfo()");
		
		if (dao.getAllTheEmployeeDetails().isEmpty()) {
			return (List<Car>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getAllTheEmployeeDetails() ),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		
		
		return dao.getAllTheEmployeeDetails();
	}
	
	
	
	
	
	// -------------------Retrieve All Names---------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET,value="/carName")
	@ResponseBody
	public List<String> getCarNameList(){
		
		logger.info("com.dataSource.controller.CarSearchController@getCarNameList()");
		
		if (dao.getAllTheCarNamesDetails().isEmpty()) {
			return (List<String>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getAllTheCarNamesDetails() ),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		
		return dao.getAllTheCarNamesDetails();
	}
	// -------------------Retrieve All Manufacture List------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET,value="/allCarDetails")
	@ResponseBody
	public List<String> getCarManufactureList(){
		
		logger.info("com.dataSource.controller.CarSearchController@getCarManufactureList()");
		
		if (dao.getAllTheCarManufactureNamesDetails().isEmpty()) {
			return (List<String>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getAllTheCarManufactureNamesDetails()),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return dao.getAllTheCarManufactureNamesDetails();
	}
	// -------------------Retrieve Model List---------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/manufactureList")
	@ResponseBody
	public List<String> getCarModelList(){
		logger.info("com.dataSource.controller.getCarModelList()");
		if (dao.getModelDetails().isEmpty()) {
			return (List<String>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getModelDetails()),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		
		return dao.getModelDetails();
	}
	// -------------------Retrieve Manufacture Year---------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/manufactureYear")
	@ResponseBody
	public List<Data> getCarManufactureYearList(){
		
		logger.info("com.dataSource.controller.getCarManufactureYearList()");
		if (dao.getAllTheCarManufacturYearDetails().isEmpty()) {
			return (List<Data>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getAllTheCarManufacturYearDetails()),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return dao.getAllTheCarManufacturYearDetails();
	}
	// -------------------Retrieve All Color List---------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET,value="/colorList")
	@ResponseBody
	public List<String> getCarColorList(){
		
		logger.info("com.dataSource.controller.getCarColorList()");
		
		if (dao.getAllTCarColorList().isEmpty()) {
			return (List<String>) new ResponseEntity(new CustomErrorType("User list is empty "+dao.getAllTCarColorList()),HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		
		return dao.getAllTCarColorList();
	}
}
