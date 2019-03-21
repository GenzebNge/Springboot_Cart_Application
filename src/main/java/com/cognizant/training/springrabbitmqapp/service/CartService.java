package com.cognizant.training.springrabbitmqapp.service;

import com.cognizant.training.springrabbitmqapp.models.Cart;
import com.cognizant.training.springrabbitmqapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart save(Cart newCart) {
        return null;
    }

    public List<Cart> getAll() {
        return null;
    }
}
