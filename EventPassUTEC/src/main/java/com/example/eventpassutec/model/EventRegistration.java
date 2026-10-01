package com.example.eventpassutec.model;

import com.example.eventpassutec.model.Enums.status3;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "Campus_event_id", nullable = false, foreignKey = @ForeignKey(name = "fk_campus_event"))
    private Long eventId;

    @JoinColumn(name = "TicketType_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_type"))
    private Long ticketTypeId;

    @JoinColumn(name = "Attendee_Id", nullable = false, foreignKey = @ForeignKey(name = "fk_User"))
    private Long attendeeId;

    @Column(name = "registered_time", nullable = false)
    private ZonedDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private status3 status;
}
