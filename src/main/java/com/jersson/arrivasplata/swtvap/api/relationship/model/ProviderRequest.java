package com.jersson.arrivasplata.swtvap.api.relationship.model;

import com.jersson.arrivasplata.swtvap.api.relationship.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ProviderRequest {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String celphone;
    private String country_code;
    private String email;
    private Boolean whatsapp;
    private String details;
    private String other_details;
    private Status status;
}
