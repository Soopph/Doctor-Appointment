package com.example.doctorAppointmentAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private int experience;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String patiens;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private String site;

    @Column(nullable = false)
    private String speciality;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
