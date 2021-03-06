package com.udacity.persistence.entities0.controller;

import com.udacity.persistence.entities0.DTO.RecipientAndPrice;
import com.udacity.persistence.entities0.model.Delivery;
import com.udacity.persistence.entities0.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery){
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId){
        return deliveryService.getBill(deliveryId);
    }
}
