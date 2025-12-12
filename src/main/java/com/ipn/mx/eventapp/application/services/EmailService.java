package com.ipn.mx.eventapp.application.services;

import com.ipn.mx.eventapp.domain.entities.AssistantEntity;

public interface EmailService {
    void sendRegistrationConfirmation(AssistantEntity assistant);
}
