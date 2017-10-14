package com.stackroute.restaurant.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.restaurant.controller.Restaurant;
import com.stackroute.restaurant.repository.RestaurantRepository;
import com.stackroute.restaurant.service.RestaurantServiceDaoImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestaurantServicesDaoImplTest {

	
	   
	   private RestaurantServiceDaoImpl productServiceImpl;
	    @Mock
	    private RestaurantRepository productRepository;
	    @Mock
	    private Restaurant product;
	    @Before
	    public void setupMock() {
	        MockitoAnnotations.initMocks(this);
	        productServiceImpl=new RestaurantServiceDaoImpl();
	        productServiceImpl.setRestaurantRepository(productRepository);
	    }
	    @Test
	    public void TestgetById() throws Exception {
	        // Arrange
	        when(productRepository.findById("2")).thenReturn(product);
	        // Act
	        Restaurant retrievedProduct = productServiceImpl.getById("2");
	        // Assert
	        assertThat(retrievedProduct, is(equalTo(product)));

	   }
	    
	    @Test
	    public void TestUpdate() throws Exception {
	        // Arrange
	        when(productRepository.save(product)).thenReturn(product);
	        // Act
	        productServiceImpl.update("1",product);
	        // Assert
	        assertThat(productRepository.findById("1"), is(productRepository.findById("1")));
	    }
	    @Test
	    public void TestDelete() throws Exception {
	        // Arrange
	        doNothing().when(productRepository).delete("1");
	        RestaurantRepository my = Mockito.mock(RestaurantRepository.class);
	        // Act
	        productServiceImpl.delete("1");
	        // Assert
	        verify(productRepository, times(1)).delete("1");
	    }
	}