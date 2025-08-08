package com.example.doctorAppointmentAPI.service;

import com.example.doctorAppointmentAPI.dto.CategoryDto;
import com.example.doctorAppointmentAPI.dto.DoctorDto;
import com.example.doctorAppointmentAPI.entity.Category;
import com.example.doctorAppointmentAPI.entity.Doctor;
import com.example.doctorAppointmentAPI.mapper.DoctorMapper;
import com.example.doctorAppointmentAPI.repository.CategoryRepository;
import com.example.doctorAppointmentAPI.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<DoctorDto> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public DoctorDto getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        return (doctor != null) ? DoctorMapper.toDto(doctor): null;
    }

    public DoctorDto saveDoctor(DoctorDto dto){

        Category category = null;
        if (dto.getCategoryId() != null){
           category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        }

        dto.setId(null);

        Doctor doctor = DoctorMapper.toEntity(dto, category);

        Doctor saved = doctorRepository.save(doctor);
        return DoctorMapper.toDto(saved);
    }

    public DoctorDto updateDoctor(Long id, DoctorDto dto){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("Doctor not found with ID" + id));

        doctor.setName(dto.getName());
        doctor.setAddress(dto.getAddress());
        doctor.setBiography(dto.getBiography());
        doctor.setExperience(dto.getExperience());
        doctor.setLocation(dto.getLocation());
        doctor.setMobile(dto.getMobile());
        doctor.setPatiens(dto.getPatiens());
        doctor.setPicture(dto.getPicture());
        doctor.setRating(dto.getRating());
        doctor.setSite(dto.getSite());
        doctor.setSpeciality(dto.getSpeciality());

        if(dto.getCategoryId()!=null){
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + dto.getCategoryId()));
            doctor.setCategory(category);
        }

        Doctor updated = doctorRepository.save(doctor);
        return DoctorMapper.toDto(updated);

    }

    public  void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
