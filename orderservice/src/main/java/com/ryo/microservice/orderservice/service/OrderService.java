package com.ryo.microservice.orderservice.service;

import com.ryo.microservice.orderservice.client.InventoryClient;
import com.ryo.microservice.orderservice.dto.request.OrderRequest;
import com.ryo.microservice.orderservice.model.Order;
import com.ryo.microservice.orderservice.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {

    OrderRepository orderRepository;
    InventoryClient inventoryClient;

    public void placeOrder(OrderRequest request){

        if(inventoryClient.isInStock(request.skuCode(), request.quantity())){
            orderRepository.save(Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(request.price())
                    .quantity(request.quantity())
                    .skuCode(request.skuCode())
                    .build());
        }
        else{
            throw new RuntimeException();
        }


        
    }

}
