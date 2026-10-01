package com.example.eventpassutec.Service;

import com.example.eventpassutec.Repository.RegistrationRepository;
import com.example.eventpassutec.model.TicketType;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final UserDetail userDetail;
}
