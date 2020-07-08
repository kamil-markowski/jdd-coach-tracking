package com.isa;

import com.isa.domain.JsonEventInLog;
import com.isa.service.RecordDownloader;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.Hashtable;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NamingException, IOException {
        Hashtable<String, String> properties = new Hashtable<String, String>();
//        properties.put(Context.INITIAL_CONTEXT_FACTORY,
//                "org.wildfly.naming.client.WildFlyInitialContextFactory");
//        properties.put("jboss.naming.client.ejb.context", "true");
//        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        properties.put(Context.SECURITY_PRINCIPAL, "kamil");
//        properties.put(Context.SECURITY_CREDENTIALS, "kamil");
//        Context context = new InitialContext(properties);
//
//        EventInLogRepositoryRemote lookup = (EventInLogRepositoryRemote) context.lookup(
//                "jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");
//
//        int size = lookup.getUsersNames().size();
//        String name = lookup.getUsersNames().get(0).toString();
//        String recString = lookup.getEventInLogRecord();
//
//        ObjectMapper mapper = new ObjectMapper();
//        Reader reader = new StringReader(recString);
//        JsonEventInLog jsonEventInLog = mapper.readValue(reader, JsonEventInLog.class);

        RecordDownloader recordDownloader =new RecordDownloader();

        JsonEventInLog jsonEventInLog = recordDownloader.getRecord();
        String ip = jsonEventInLog.getIp();
        String date = jsonEventInLog.getEventDate();

        System.out.println(jsonEventInLog.getCoachInfoLink());
        System.out.println(jsonEventInLog.getEventName());
        System.out.println(jsonEventInLog.getId());
        System.out.println(jsonEventInLog.getEventDate());

//        System.out.println(recString);
//        System.out.println(ip);
//        System.out.println(size);
    }
}
