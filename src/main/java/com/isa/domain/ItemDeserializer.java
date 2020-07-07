package com.isa.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;

public class ItemDeserializer extends StdDeserializer<EventInLog> {

    public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public EventInLog deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

//        Integer id = (Integer) ((IntNode) node.get("id")).numberValue();
        Long idLong = Long.parseLong(((IntNode) node.get("id")).asText());

        String ip = node.get("ip").asText();

        String eventName = node.get("eventName").asText();

        String coachInfoLink = node.get("coachInfoLink").asText();

        String localDateTime =  (node.get("eventDate")).asText();

        EventInLog parsedEventInLog = new EventInLog(idLong, ip, eventName,coachInfoLink,localDateTime);

        parsedEventInLog.setId(idLong);
        parsedEventInLog.setIp(ip);
        parsedEventInLog.setEventName(eventName);
        parsedEventInLog.setCoachInfoLink(coachInfoLink);
        parsedEventInLog.setEventDate(localDateTime);

        return parsedEventInLog;
    }
}