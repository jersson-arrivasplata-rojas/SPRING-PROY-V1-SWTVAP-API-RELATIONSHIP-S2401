package com.jersson.arrivasplata.swtvap.api.relationship.model;

import com.jersson.arrivasplata.swtvap.api.relationship.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "swtvap_providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    private String celphone;

    @Column(length = 5)
    private String country_code;

    @Column(length = 50)
    private String email;

    @Column(name = "whatsapp", columnDefinition = "TINYINT(1)")
    private Boolean whatsapp;

    @Column(length = 255)
    private String details;

    @Column(columnDefinition = "TEXT")
    private String other_details;

    @Enumerated(EnumType.STRING)
    private Status status;
}
