package com.isa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(using = DeserializerEventInLog.class)
public class JsonEventInLog {

    @JsonProperty ("id")
    private String id;

    @JsonProperty ("ip")
    private String ip;

    @JsonProperty ("eventName")
    private String eventName;

    @JsonProperty ("coachInfoLink")
    private String coachInfoLink;

    @JsonProperty ("eventDate")
    private String eventDate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCoachInfoLink() {
        return coachInfoLink;
    }

    public void setCoachInfoLink(String coachInfoLink) {
        this.coachInfoLink = coachInfoLink;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "ip='" + ip + '\'' +
                "eventName='" + eventName + '\'' +
                "coachInfoLink='" + coachInfoLink + '\'' +
                "eventDate='" + eventDate + '\'' +
                "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JsonEventInLog jsonEventInLog = (JsonEventInLog) o;
        return Objects.equals(id, jsonEventInLog.id) &&
                Objects.equals(ip, jsonEventInLog.ip) &&
                Objects.equals(eventName, jsonEventInLog.eventName) &&
                Objects.equals(coachInfoLink, jsonEventInLog.coachInfoLink) &&
                Objects.equals(eventDate, jsonEventInLog.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,ip,eventName,eventDate,coachInfoLink);
    }
}

