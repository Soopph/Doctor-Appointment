package com.example.doctorAppointmentAPI.repository;

import com.example.doctorAppointmentAPI.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor, Long>{

}
