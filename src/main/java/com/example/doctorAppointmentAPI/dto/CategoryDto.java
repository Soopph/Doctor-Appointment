package com.example.doctorAppointmentAPI.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CategoryDto {
    private Long id;
    private String name;
    private String picture;
    private List<DoctorDto> doctors;
}
