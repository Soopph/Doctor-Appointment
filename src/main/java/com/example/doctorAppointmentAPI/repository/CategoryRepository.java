package com.example.doctorAppointmentAPI.repository;

import com.example.doctorAppointmentAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long>{
}
