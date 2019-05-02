package com.matrix.codechallenge.springboot.web.controller;

import com.matrix.codechallenge.springboot.web.DAO.User;
import com.matrix.codechallenge.springboot.web.repository.UserRepository;
import com.matrix.codechallenge.springboot.web.service.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/appointment")
public class AppointmentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointmentServices appointmentServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String setAppointment(HttpServletRequest req,
                                 @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        appointmentServices.addAppointment(user);
        String page = "appointment-confirmation";
        return page;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAppointment(HttpServletRequest req,
                                 @RequestParam String confirmationCode, Model model) {

        String page = "appointment-details";
        System.out.println(confirmationCode);
        User user = (User) appointmentServices.getAppointmentDetails(confirmationCode);
        model.addAttribute("user", user);
        return page;
    }
}
