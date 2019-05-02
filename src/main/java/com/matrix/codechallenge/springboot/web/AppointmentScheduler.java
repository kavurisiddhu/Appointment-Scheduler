package com.matrix.codechallenge.springboot.web;

import com.matrix.codechallenge.springboot.web.model.Appointment;
import com.matrix.codechallenge.springboot.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class AppointmentScheduler {

    @Autowired
    UserRepository userRepository;

//	private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {

        SpringApplication.run(AppointmentScheduler.class, args);
    }

    public void run(String[] args) {
        Appointment appoinment = new Appointment(new Timestamp(new java.util.Date().getTime()));
        Set<Appointment> appointmentList = new HashSet<Appointment>();
        appointmentList.add(appoinment);
        com.matrix.codechallenge.springboot.web.model.User userModel = new com.matrix.codechallenge.springboot.web.model.User();
        userModel.setLast_name("Steve");
        userModel.setFirst_name("Roger");
        userModel.setDob(new java.sql.Date(85, 6, 12));
        userModel.setAppointments(appointmentList);
        userRepository.save(userModel);
    }
}
