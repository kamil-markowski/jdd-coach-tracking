package com.isa.domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "EventInLog.findAll",
                query = "SELECT e FROM EventInLog e"
        )
})

@Entity
@Table(name = "event_in_log")
public class EventInLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    private String eventName;

    private String coachInfoLink;

    private String eventDate;

    public EventInLog(Long id, String ip, String eventName, String coachInfoLink, String localDateTime) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
