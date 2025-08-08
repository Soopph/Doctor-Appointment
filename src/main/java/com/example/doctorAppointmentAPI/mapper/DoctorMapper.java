package com.example.doctorAppointmentAPI.mapper;

import com.example.doctorAppointmentAPI.dto.DoctorDto;
import com.example.doctorAppointmentAPI.entity.Doctor;
import com.example.doctorAppointmentAPI.entity.Category;

import javax.print.Doc;

public class DoctorMapper {

    public static DoctorDto toDto(Doctor doctor){
        Long categoryId = doctor.getCategory() !=null ? doctor.getCategory().getId() : null;

        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .address(doctor.getAddress())
                .biography(doctor.getBiography())
                .experience(doctor.getExperience())
                .location(doctor.getLocation())
                .mobile(doctor.getMobile())
                .patiens(doctor.getPatiens())
                .picture(doctor.getPicture())
                .rating(doctor.getRating())
                .site(doctor.getSite())
                .speciality(doctor.getSpeciality())
                .categoryId(doctor.getCategory().getId())
                .build();
    }

    public static Doctor toEntity(DoctorDto dto, Category category){
        return Doctor.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .biography(dto.getBiography())
                .experience(dto.getExperience())
                .location(dto.getLocation())
                .mobile(dto.getMobile())
                .patiens(dto.getPatiens())
                .picture(dto.getPicture())
                .rating(dto.getRating())
                .site(dto.getSite())
                .speciality(dto.getSpeciality())
                .category(category)
                .build();
    }
}
