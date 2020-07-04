package com.isa;

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

//        EventInLogRepositoryRemote getName = (EventInLogRepositoryRemote) context.lookup
//                ("jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");
//        getName.getClass();


        EventInLogRepositoryRemote lookup = (EventInLogRepositoryRemote) context.lookup(
                "jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");
//        lookup.findAll().forEach(System.out::println);
//        EventInLogRepositoryRemote x = (EventInLogRepositoryRemote) context.lookup("jdd-coach/EventInLogRepositoryBean!engine.repository.EventInLogRepositoryRemote");


        int size = lookup.getUsersNames().size();
        lookup.getUsersNames().get(0).toString();
//        x.findAll();
        System.out.println(size);
        lookup.getUsersNames().forEach(System.out::println);

        System.out.println(EventInLogRepositoryRemote.class.getClass());
    }
}
