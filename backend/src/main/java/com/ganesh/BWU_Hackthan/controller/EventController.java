package com.ganesh.BWU_Hackthan.controller;

import com.ganesh.BWU_Hackthan.exception.APIException;
import com.ganesh.BWU_Hackthan.model.Event;
import com.ganesh.BWU_Hackthan.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Event> create(@RequestBody Event event) {
        Event savesEvent = eventService.createEvent(event);
        return new ResponseEntity<>(savesEvent,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllPublished() {
        List<Event> events =  eventService.getAllPublishedEvents();
        return new ResponseEntity<>(events,HttpStatus.FOUND);
    }

//    @GetMapping("/admin")
//    public List<Event> getAllEventsForAdmin() {
//        return eventService.getAllEvents();
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody Event event) {
        Event updatedEvent =  eventService.updateEvent(id, event);
        return new ResponseEntity<>(updatedEvent,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
         Event event = eventService.deleteEvent(id);
         if (event == null){
             throw new APIException("Can't Delete, Event Not Available");
         }else {
             return new ResponseEntity<>("Event Delete successfully", HttpStatus.OK);
         }

    }
}

