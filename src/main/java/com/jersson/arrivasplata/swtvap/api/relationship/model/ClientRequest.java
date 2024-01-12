package com.jersson.arrivasplata.swtvap.api.relationship.model;

import com.jersson.arrivasplata.swtvap.api.relationship.enums.Status;

public class ClientRequest {
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
    private Status source_aggregate;
}
