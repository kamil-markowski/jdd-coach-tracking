package com.isa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.isa.domain.EventInLog;
import com.isa.domain.ItemDeserializer;
import engine.repository.EventInLogRepositoryRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws NamingException
    {
        System.out.println( "Hello World!" );
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", "true");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "kamil");
        properties.put(Context.SECURITY_CREDENTIALS, "kamil");
        Context context = new InitialContext(properties);


        EventInLogRepositoryRemote lookup = (EventInLogRepositoryRemote) context.lookup(
                "jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");

        int size = lookup.getUsersNames().size();
        String name = lookup.getUsersNames().get(0).toString();
        String recString = lookup.getEventInLogRecord();

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(EventInLog.class, new ItemDeserializer());
        mapper.registerModule(module);

        EventInLog eventFromJson = null;
        try {
            eventFromJson = mapper.readValue(recString, EventInLog.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        EventInLog result = eventFromJson;

        System.out.println(eventFromJson);
        System.out.println(size);
//        lookup.getUsersNames().forEach(System.out::println);
//        System.out.println(EventInLogRepositoryRemote.class.getClass());
//        System.out.println(name);
        System.out.println(recString);
    }
}
