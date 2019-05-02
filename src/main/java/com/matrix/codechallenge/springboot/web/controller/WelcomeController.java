package com.matrix.codechallenge.springboot.web.controller;

import com.matrix.codechallenge.springboot.web.DAO.Appointment;
import com.matrix.codechallenge.springboot.web.DAO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(HttpServletRequest req, Model model) {
        User user = new User();
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        model.addAttribute("user", user);
        //return new ModelAndView("welcome","user", new User());
        return "welcome";
    }

}
