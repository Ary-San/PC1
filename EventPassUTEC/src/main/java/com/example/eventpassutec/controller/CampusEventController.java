package com.example.eventpassutec.controller;

import com.example.eventpassutec.Service.EventService;
import com.example.eventpassutec.model.CampusEvent;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated
public class CampusEventController {
    private static final String ALL = "all";
    private final EventService eventService;

    public CampusEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<CampusEvent> create(@Valid @RequestBody CampusEvent campusEvent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.create(request));
    }

    @PutMapping("")
}
