package com.isa.repository;

import com.isa.domain.EventInLog;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface EventInLogRepository {

    void save(EventInLog eventInLog);

    Optional<EventInLog> findByUserId (Long id);

    List<EventInLog> findAll();
}
