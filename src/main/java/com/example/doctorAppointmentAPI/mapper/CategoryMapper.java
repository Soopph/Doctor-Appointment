package com.example.doctorAppointmentAPI.mapper;

import com.example.doctorAppointmentAPI.dto.CategoryDto;
import com.example.doctorAppointmentAPI.entity.Category;
import com.example.doctorAppointmentAPI.entity.Doctor;
import com.example.doctorAppointmentAPI.dto.DoctorDto;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .picture(category.getPicture())
                .doctors(category.getDoctors() != null
                ? category.getDoctors().stream()
                        .map(DoctorMapper::toDto)
                        .collect(Collectors.toList())
                        :null)
                .build();
    }

    public static Category toEntity(CategoryDto dto){
        return  Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .picture(dto.getPicture())
                //Aqui no mapeamos la lista de doctores para evitar ciclos infinitos
                .build();
    }
}
