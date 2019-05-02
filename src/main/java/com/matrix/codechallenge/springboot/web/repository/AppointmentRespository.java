package com.matrix.codechallenge.springboot.web.repository;

import com.matrix.codechallenge.springboot.web.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRespository extends JpaRepository<Appointment, Long> {

}
