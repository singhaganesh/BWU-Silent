package com.ganesh.BWU_Hackthan.repository;

import com.ganesh.BWU_Hackthan.model.FoodOrder;
import com.ganesh.BWU_Hackthan.model.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

}
