package com.example.eventpassutec.model;

import com.example.eventpassutec.model.Enums.status2;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "Campus_event_id", nullable = false, foreignKey = @ForeignKey(name = "fk_campus_event"))
    private CampusEvent eventId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Min(0)
    private Integer capacity;

    @Column(name = "registered_count")
    private Integer registeredCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private status2 status;

}
