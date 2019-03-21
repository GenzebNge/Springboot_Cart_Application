package com.cognizant.training.springrabbitmqapp.rabbitmq;

import com.cognizant.training.springrabbitmqapp.models.Item;
import com.cognizant.training.springrabbitmqapp.service.ItemService;
import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class HelloReceiver {
    @Autowired
    private ItemService itemService;

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] in) {
        String s = new String(in);
        Gson gson = new Gson();
        Item item = gson.fromJson(s, Item.class);

        item = itemService.save(item);
        System.out.printf("Item Saved id %d%n", item.getId());

        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
