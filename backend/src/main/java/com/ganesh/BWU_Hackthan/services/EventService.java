package com.ganesh.BWU_Hackthan.services;

import com.ganesh.BWU_Hackthan.exception.APIException;
import com.ganesh.BWU_Hackthan.model.Event;
import com.ganesh.BWU_Hackthan.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllPublishedEvents() {
        return eventRepository.findByPublishedTrue();
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event deleteEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()){
            return event.get();
        }else {
            throw new APIException("Can't Delete, Event Not Available");
        }
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event event = eventRepository.findById(id).orElseThrow();
        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setDate(updatedEvent.getDate());
        event.setLocation(updatedEvent.getLocation());
        event.setPublished(updatedEvent.isPublished());
        return eventRepository.save(event);
    }
}
