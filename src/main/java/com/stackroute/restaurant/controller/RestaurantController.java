package com.stackroute.restaurant.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.restaurant.repository.RestaurantRepository;
import com.stackroute.restaurant.service.RestaurantServiceDaoImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="onlinestore", description="Restaurant Services Operation")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantServiceDaoImpl dummyService;
	
	@RequestMapping(value="/restaurants",produces = "application/json",method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available restaurants", response = Iterable.class)
	public ResponseEntity<Iterable<Restaurant>> getAllRestaurant( )
	{
		
		return new ResponseEntity<Iterable<Restaurant>>(restaurantRepository.findAll(), HttpStatus.OK) ;
	}
	
	@GetMapping("/restaurants/{name:[a-zA-Z]+}")
	@ApiOperation(value = "restaurant for given name", response = Iterable.class)
	public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable("name") String name )
	{
		
		return new ResponseEntity<Restaurant>(restaurantRepository.findByName(name), HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/restaurants/{id:[0-9]+}",produces = "application/json")
	@ApiOperation(value = "restaurant for given Id", response = Iterable.class)
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") String id)
	{
		return new ResponseEntity<Restaurant>(dummyService.getById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/restaurants")
	public ResponseEntity addrestaurant(@RequestBody Restaurant restaurnat)
	{
		/*Add validation code*/	
		dummyService.add(restaurnat);
		return new ResponseEntity<String>("Added successfully", HttpStatus.OK) ;
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/restaurants/{id}")
	public  ResponseEntity updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable String id)
	{
		dummyService.update(id,restaurant);
		return new ResponseEntity<String>("Updated successfully", HttpStatus.OK) ;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/restaurants/{id}")
	public  ResponseEntity deleteRestaurant(@PathVariable String id)
	{
		dummyService.delete(id);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK) ;
		
	}
	
	
}
