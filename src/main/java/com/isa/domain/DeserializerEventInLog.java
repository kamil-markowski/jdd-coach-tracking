package com.isa.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class DeserializerEventInLog extends JsonDeserializer<JsonEventInLog> {
    @Override
    public JsonEventInLog deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        JsonEventInLog jsonEventInLog = new JsonEventInLog();

        JsonNode readValueAsTree = jsonParser.readValueAsTree();

        jsonEventInLog.setId(readValueAsTree.get("id").asText());
        jsonEventInLog.setIp(readValueAsTree.get("ip").asText());
        jsonEventInLog.setEventName(readValueAsTree.get("eventName").asText());
        jsonEventInLog.setCoachInfoLink(readValueAsTree.get("coachInfoLink").asText());
        jsonEventInLog.setEventDate(readValueAsTree.get("eventDate").asText());

        return jsonEventInLog;
    }

}
