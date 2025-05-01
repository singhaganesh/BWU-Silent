package com.ganesh.BWU_Hackthan.services;

import com.ganesh.BWU_Hackthan.model.FoodOrder;
import com.ganesh.BWU_Hackthan.repository.FoodOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public FoodOrder placeOrder(FoodOrder order) {
        return foodOrderRepository.save(order);
    }

    public List<FoodOrder> getAllOrders() {
        return foodOrderRepository.findAll();
    }
}
