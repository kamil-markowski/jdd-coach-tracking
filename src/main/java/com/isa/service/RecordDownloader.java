package com.isa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.domain.JsonEventInLog;
import engine.repository.EventInLogRepositoryRemote;

import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;

@RequestScoped
public class RecordDownloader {

    public JsonEventInLog getRecord(){
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", "true");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "kamil");
        properties.put(Context.SECURITY_CREDENTIALS, "kamil");
        Context context = null;
        try {
            context = new InitialContext(properties);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        EventInLogRepositoryRemote lookup = null;
        try {
            lookup = (EventInLogRepositoryRemote) context.lookup(
                    "jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        int size = lookup.getUsersNames().size();
        String name = lookup.getUsersNames().get(0).toString();
        String recString = lookup.getEventInLogRecord();

        ObjectMapper mapper = new ObjectMapper();
        Reader reader = new StringReader(recString);
        JsonEventInLog jsonEventInLog = null;
        try {
            jsonEventInLog = mapper.readValue(reader, JsonEventInLog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ip = jsonEventInLog.getIp();
        String date = jsonEventInLog.getEventDate();

        return jsonEventInLog;
    }
}
