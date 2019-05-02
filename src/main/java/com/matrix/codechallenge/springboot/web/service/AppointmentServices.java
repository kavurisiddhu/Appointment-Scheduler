package com.matrix.codechallenge.springboot.web.service;

import com.matrix.codechallenge.springboot.web.DAO.User;

public interface AppointmentServices {
    public void addAppointment(User user);

    public User getAppointmentDetails(String confirmationCode);
}
