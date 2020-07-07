package com.isa.repository;

import com.isa.domain.EventInLog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class EventInLogRepositoryBean implements EventInLogRepository{

    private final static Logger logger = Logger.getLogger(EventInLogRepositoryBean.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(EventInLog eventInLog) {
        entityManager.persist(eventInLog);
    }

    @Override
    public Optional<EventInLog> findByUserId(Long id) {
        return Optional.ofNullable(entityManager.find(EventInLog.class, id));
    }

    @Override
    public List<EventInLog> findAll() {
        Query query = entityManager
                .createNamedQuery("EventInLog.findAll");
        List resultList = query.getResultList();
        return resultList;
    }
//    @Override
//    public List<String> getEventsInLogList() {
//
//        return null;
//    }

}
