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
        String confirmationCode=appointmentServices.addAppointment(user);
        String page = "appointment-confirmation";
        if(null!=confirmationCode) {
            model.addAttribute("fullName", user.getFirstName() + ", " + user.getLastName());
            model.addAttribute("confirmationCode", confirmationCode);
            model.addAttribute("status",true);
        }else{
            model.addAttribute("status",false);
            model.addAttribute("errorMessage","Error scheduling appointment, please try again later..");
        }
        return page;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAppointment(HttpServletRequest req,
                                 @RequestParam String confirmationCode, Model model) {

        String page = "appointment-details";
        System.out.println(confirmationCode);
        User user = appointmentServices.getAppointmentDetails(confirmationCode);
        if(null==user){
            model.addAttribute("errorMessage","Error in viewing appointment details..");
        }else{
            model.addAttribute("user", user);
        }
        return page;
    }
}
