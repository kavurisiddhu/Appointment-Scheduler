package com.matrix.codechallenge.springboot.web.service.impl;

import com.matrix.codechallenge.springboot.web.DAO.User;
import com.matrix.codechallenge.springboot.web.model.Appointment;
import com.matrix.codechallenge.springboot.web.repository.AppointmentRespository;
import com.matrix.codechallenge.springboot.web.repository.UserRepository;
import com.matrix.codechallenge.springboot.web.service.AppointmentServices;
import com.matrix.codechallenge.springboot.web.utils.TransformUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class AppointmentServicesImpl implements AppointmentServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointmentRespository appointmentRespository;

    @Override
    public  String addAppointment(User user) {
        com.matrix.codechallenge.springboot.web.model.User userModel = TransformUtils.convertWebUserToDataUser(user);
        userModel=userRepository.save(userModel);
        String confirmationCode="";
        Iterator it=userModel.getAppointments().iterator();
        if(it.hasNext()){
            confirmationCode=((Appointment)it.next()).getAppointment_id().toString();
        }
        return confirmationCode;
    }

    @Override
    public com.matrix.codechallenge.springboot.web.DAO.User getAppointmentDetails(String confirmationCode) {
        Appointment appointment = appointmentRespository.findOne(TransformUtils.convertWebToDBGetAppointmentDetails(confirmationCode));
        com.matrix.codechallenge.springboot.web.DAO.User user = null;
        if (null != appointment) {
            user = TransformUtils.convertDBAppointmentToWeb(appointment);
        }
        return user;
    }
}
