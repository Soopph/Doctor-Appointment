package com.example.doctorAppointmentAPI.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DoctorDto {

    private Long id;
    private String name;
    private String address;
    private String biography;
    private int experience;
    private String location;
    private String mobile;
    private String patiens;
    private String picture;
    private double rating;
    private String site;
    private String speciality;

    private Long categoryId;
}
