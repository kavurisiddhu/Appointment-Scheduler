package com.matrix.codechallenge.springboot.web.utils;

import com.matrix.codechallenge.springboot.web.DAO.User;
import com.matrix.codechallenge.springboot.web.model.Appointment;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class TransformUtils {

    public static com.matrix.codechallenge.springboot.web.model.User convertWebUserToDataUser(User user) {
        com.matrix.codechallenge.springboot.web.model.User userModel = null;
        Set<Appointment> appointments = new HashSet<Appointment>();
        if (null != user) {
            userModel = new com.matrix.codechallenge.springboot.web.model.User();
            userModel.setDob(convertsStringToSqlDate(user.getDob()));
            userModel.setFirst_name(user.getFirstName());
            userModel.setLast_name(user.getLastName());
            Appointment appointment = new Appointment();
            appointment.setAppointment_date(
                    convertsStringToSqlAppointmentDate(user.getAppointment().getAppointmentDate(), user.getAppointment().getAppointmentTime()));
            appointments.add(appointment);
            userModel.setAppointments(appointments);
        }
        return userModel;
    }

    public static java.sql.Date convertsStringToSqlDate(String strDate) {

        SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date date = null;
        try {
            date = new java.sql.Date(sf.parse(strDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static java.sql.Timestamp convertsStringToSqlAppointmentDate(String strDate, String time) {

        SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy hh");
        java.sql.Timestamp date = null;
        try {
            date = new java.sql.Timestamp(sf.parse(strDate + " " + time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Long convertWebToDBGetAppointmentDetails(String confirmationCode) {
        return Long.parseLong(confirmationCode);
    }

    public static String convertDBDateToDate(Timestamp date) {
        return date.toString();
    }

    public static com.matrix.codechallenge.springboot.web.DAO.User convertDBAppointmentToWeb(Appointment appointment) {
        com.matrix.codechallenge.springboot.web.DAO.User user = new com.matrix.codechallenge.springboot.web.DAO.User();
        com.matrix.codechallenge.springboot.web.DAO.Appointment appointment1 = new com.matrix.codechallenge.springboot.web.DAO.Appointment();
        user.setFirstName(appointment.getUser().getFirst_name());
        user.setLastName(appointment.getUser().getLast_name());
        appointment1.setAppointmentDate(convertDBDateToDate(appointment.getAppointment_date()));
        appointment1.setConfirmationCode(appointment.getAppointment_id().toString());
        user.setAppointment(appointment1);
        return user;
    }
}
