package com.ganesh.BWU_Hackthan.controller;

import com.ganesh.BWU_Hackthan.model.FoodOrder;
import com.ganesh.BWU_Hackthan.services.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class FoodOrderController {
    @Autowired
    private FoodOrderService service;


    @PostMapping("/place")
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return service.placeOrder(order);
    }

    @GetMapping("/all")
    public List<FoodOrder> allOrders() {
        return service.getAllOrders();
    }
}
