package com.cognizant.training.springrabbitmqapp.service;

import com.cognizant.training.springrabbitmqapp.models.Cart;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CartServiceTest {
    @Autowired
    private CartService cartService;
    private Cart cart;

    @Before
    public void init() {
        cart = new Cart();
    }


}