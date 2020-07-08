package com.isa.servlet;

import com.isa.domain.EventInLog;
import com.isa.service.EventInLogService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-event")
public class AddTest extends HttpServlet {

//    @EJB
////            (lookup = java:jboss/exported/jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote);
//            (lookup="java:global/jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote")
//    private EventInLogRepositoryRemote eventInLogRepositoryRemote;

//    @Inject
//    RecordDownloader recordDownloader;

    @Inject
    EventInLogService eventInLogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



//        JsonEventInLog jsonEventInLog = recordDownloader.getRecord();
//
//        EventInLog eventInLog = null;
//        eventInLog.setId(Long.parseLong(jsonEventInLog.getId()));
//        eventInLog.setCoachInfoLink(jsonEventInLog.getCoachInfoLink());
//        eventInLog.setEventName(jsonEventInLog.getEventName());
//        eventInLog.setEventDate(jsonEventInLog.getEventDate());
//
//        eventInLogService.save(eventInLog);

        EventInLog eventInLog = new EventInLog();
        eventInLog.setIp("test ip 1.0.0.0.0");
        eventInLog.setCoachInfoLink("link test");
        eventInLog.setEventName("test name");
        eventInLog.setEventDate("test date");

        eventInLogService.save(eventInLog);

//        resp.sendRedirect("/");
    }
}



