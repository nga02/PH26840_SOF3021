package com.example.ph26840.assigment.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomController {
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        return m;
    }
}
