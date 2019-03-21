package com.cognizant.training.springrabbitmqapp.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {
    public void receiveMessage(byte[] in) {
        String s = new String(in);
        System.out.println("Received <" + s + ">");

    }

}
