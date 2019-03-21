package com.cognizant.training.springrabbitmqapp.service;

import com.cognizant.training.springrabbitmqapp.models.Cart;
import com.cognizant.training.springrabbitmqapp.models.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    private Cart cart;
    private Item testItem1;
    private Item testItem2;

    @Before
    public void init() {
        cart = new Cart();
        testItem1 = new Item()
                .withName("Popcorn")
                .withPrice(12.34)
                .withQuantity(2);
        testItem2 = new Item()
                .withName("Cola")
                .withPrice(1.34)
                .withQuantity(1);
        cart.setItems(Arrays.asList(testItem1, testItem2));
    }

    @Test
    public void saveNewCartToDataBase() {
        Cart savedCart = cartService.save(cart);
        assertNotNull("Should return the cart itself", savedCart);
        assertNotNull("Should return an id for cart", savedCart.getId());
        assertNotNull("First Item should be added", cart.getItems().get(0).getId());
        assertNotNull("Second Item should be added", cart.getItems().get(1).getId());
    }
}