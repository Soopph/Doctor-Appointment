package com.example.doctorAppointmentAPI.controller;

import com.example.doctorAppointmentAPI.dto.DoctorDto;
import com.example.doctorAppointmentAPI.entity.Doctor;
import com.example.doctorAppointmentAPI.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor

public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAll(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> save (@RequestBody DoctorDto dto){
        return ResponseEntity.ok(doctorService.saveDoctor(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> update (@PathVariable Long id, @RequestBody DoctorDto dto){
        return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
