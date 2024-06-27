package com.example.Bookingevent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Bookingevent.model.Event;
import com.example.Bookingevent.repository.EventRepo;

@Service
public class EventService {
    @Autowired
    private final EventRepo repo;

    public List<Event> getEventById() {
        return repo.findAll();
    }

    public List<Event> sortTheRecords(String clientName) {
        return repo.findAll(Sort.by(Sort.Direction.DESC, clientName));
    }

    public List<Event> getPaginationSignin(int offset, int size) {
        return repo.findAll(PageRequest.of(offset, size)).getContent();
    }

    public List<Event> getSortedPaginationSignin(int offset, int size, String field) {
        return repo.findAll(PageRequest.of(offset, size,
                Sort.by(field))).getContent();
    }

    public EventService(EventRepo repo) {
        this.repo = repo;
    }

    @SuppressWarnings("null")
    public Event addCustomer(Event p) {
        return repo.save(p);
    }

    public Event update(int id, Event client) {
        Event pros = repo.findById(id).orElse(null);
        if (pros != null) {
            pros.setId(client.getId());
            pros.setEventName(client.getEventName());
            pros.setCustomerId(client.getCustomerId());
            return repo.save(pros);
        }
        return client;
    }

    public void delete(int clientId) {
        repo.deleteById(clientId);

    }

}