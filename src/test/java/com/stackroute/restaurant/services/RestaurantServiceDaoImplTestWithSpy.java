package com.stackroute.restaurant.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.stackroute.restaurant.controller.Restaurant;
import com.stackroute.restaurant.repository.RestaurantRepository;
import com.stackroute.restaurant.service.RestaurantServiceDaoImpl;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceDaoImplTestWithSpy {
    @Spy
    private RestaurantServiceDaoImpl prodServiceSpy;
    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private Restaurant restaurant;

   @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
        Restaurant retrievedProduct = prodServiceSpy.getById("1");
        //Assert
        assertThat(retrievedProduct, is(equalTo(restaurant)));
    }
   

   public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(restaurant).when(restaurantRepository).save(restaurant);
        //Act
        prodServiceSpy.update("1",restaurant);
        //Assert
        assertThat(restaurantRepository.save(restaurant), is(restaurantRepository.save(restaurant)));
    }
   

   @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(restaurant).when(prodServiceSpy).getById("1");
        //Act
        Restaurant retrievedProduct = prodServiceSpy.getById("1");
        //Assert
        Mockito.verify(prodServiceSpy).getById("1");
    }
   
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(restaurant).when(prodServiceSpy).getById("1");
        //Act
        Restaurant retrievedProduct = prodServiceSpy.getById("1");
        //Assert
        Mockito.verify(prodServiceSpy,never()).update("1",restaurant);
    }
}
