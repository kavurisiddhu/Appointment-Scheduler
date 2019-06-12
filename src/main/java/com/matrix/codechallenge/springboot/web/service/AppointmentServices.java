package com.matrix.codechallenge.springboot.web.service;

import com.matrix.codechallenge.springboot.web.DAO.Appointment;
import com.matrix.codechallenge.springboot.web.DAO.User;

public interface AppointmentServices {
    public String addAppointment(User user);

    public User getAppointmentDetails(String confirmationCode);


}
