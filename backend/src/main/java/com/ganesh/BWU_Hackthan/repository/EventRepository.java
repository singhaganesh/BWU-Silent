package com.ganesh.BWU_Hackthan.repository;

import com.ganesh.BWU_Hackthan.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByPublishedTrue(); // To fetch only visible events
}
