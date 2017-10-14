package com.stackroute.restaurant.controller;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restaurant.Foodie;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Foodie.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantControllerTest  extends TestCase {
   
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Restaurant restaurant;    
   
    @Before
    public void setUp() throws Exception {
    	restaurant = new Restaurant("1","Restaurant","description");
    }
    
   private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
   @After
    public void tearDown() throws Exception {
    }
    
   @Test
    public void addrestaurant() throws Exception { 

       HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/restaurants"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Added successfully",actual);
    }
    
   @Test
    public void getAllrestaurant() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/restaurants"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
   @Test
    public void testGetUser() throws Exception {
    }
    
   @Test
    public void updateUser() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/restaurants/3"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Updated successfully",actual);
    }
    
   @Test
    public void deleteRestaurant() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Restaurant> entity = new HttpEntity<Restaurant>(restaurant, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/restaurants/1"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Deleted successfully",actual);
    }
    
}

