package com.isa.service;

import com.isa.domain.EventInLog;
import com.isa.repository.EventInLogRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EventInLogService {

    @EJB
    private EventInLogRepository eventInLogRepository;

    public void save(EventInLog eventInLog) {
        eventInLogRepository.save(eventInLog);
    }

    public EventInLog findByUserId (Long id) {
        return eventInLogRepository.findByUserId(id).orElse(null);
    }

    public List<EventInLog> findAll() {
        return eventInLogRepository.findAll();
    }
}
