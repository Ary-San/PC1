package com.example.eventpassutec.model;

import com.example.eventpassutec.model.Enums.category;
import com.example.eventpassutec.model.Enums.status;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "campusEvent", indexes = {@Index(name = "idx_campusEvent_start_time", columnList = "start_time")})
public class CampusEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false, foreignKey = @ForeignKey(name = "User"))
    private User organizerId;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false,  length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private category category;

    @Column(nullable = false,  name = "eventDate")
    private ZonedDateTime eventDate;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private status status;
}
