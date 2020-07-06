package com.isa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime eventDate;

}
