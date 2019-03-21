package com.cognizant.training.springrabbitmqapp.service;

import com.cognizant.training.springrabbitmqapp.models.Cart;
import com.cognizant.training.springrabbitmqapp.models.Item;
import com.cognizant.training.springrabbitmqapp.repository.CartRepository;
import com.cognizant.training.springrabbitmqapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item newItem) {
        return itemRepository.save(newItem);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
