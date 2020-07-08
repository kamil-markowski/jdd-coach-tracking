package com.isa.controller;

import com.isa.domain.EventInLog;
import com.isa.repository.EventInLogRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class EventAndLogController {

    @Inject
    EventInLogRepository eventInLogRepository;

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EventInLog> findAll() {
        return eventInLogRepository.findAll();
    }

    @POST
    @Path("/add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public void save(EventInLog eventInLog) {
        eventInLogRepository.save(eventInLog);
    }
}
