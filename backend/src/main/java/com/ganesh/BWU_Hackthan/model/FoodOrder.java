package com.ganesh.BWU_Hackthan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "food_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String foodItem;
    private int quantity;
    private LocalDateTime orderTime;

    @PrePersist
    public void setOrderTime() {
        this.orderTime = LocalDateTime.now();
    }
}

