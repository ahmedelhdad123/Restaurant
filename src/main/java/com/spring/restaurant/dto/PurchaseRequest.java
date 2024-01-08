package com.spring.restaurant.dto;

import com.spring.restaurant.entity.Address;
import com.spring.restaurant.entity.Client;
import com.spring.restaurant.entity.Items;
import com.spring.restaurant.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest { // to save All (Request,Client,Address,Items)
    private Client client;
    private Request request;
    private List<Items> items;
    private Address address;

}
