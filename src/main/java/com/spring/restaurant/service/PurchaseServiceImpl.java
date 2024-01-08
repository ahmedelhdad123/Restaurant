package com.spring.restaurant.service;

import com.spring.restaurant.dao.ClientRepository;
import com.spring.restaurant.dto.PurchaseRequest;
import com.spring.restaurant.dto.PurchaseResponse;
import com.spring.restaurant.entity.Items;
import com.spring.restaurant.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private ClientRepository clientRepository;
    @Override
    @Transactional
    public PurchaseResponse addRequestOrder(PurchaseRequest purchases) { // when save client (save request(save address and items)) by casecade.All
        Request request=purchases.getRequest();
        String myCode=getCode();
        request.setCode(myCode);

        List<Items> itemsList=purchases.getItems();
        itemsList.forEach(items -> request.addItem(items));

        request.setAddress(purchases.getAddress());

        purchases.getClient().addRequest(request);


        clientRepository.save(purchases.getClient());
        return new PurchaseResponse(purchases.getClient().getFullName(),myCode);
    }

    private String getCode() {
       return UUID.randomUUID().toString();
    }
}
