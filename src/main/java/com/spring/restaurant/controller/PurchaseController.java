package com.spring.restaurant.controller;

import com.spring.restaurant.dto.PurchaseRequest;
import com.spring.restaurant.dto.PurchaseResponse;
import com.spring.restaurant.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/buy")
public class PurchaseController {


    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("addRequestOrder") // api/buy/addRequestOrder
    public PurchaseResponse addRequestOrder(@RequestBody PurchaseRequest purchaseRequest)
    {
        return purchaseService.addRequestOrder(purchaseRequest);
    }
}
