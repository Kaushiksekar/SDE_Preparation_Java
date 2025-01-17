package com.tutorials.springboot.controller;

import com.tutorials.springboot.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private JokesService jokesService;

    @Autowired
    public JokeController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model){ // spring boot will send this model as input parameter
        model.addAttribute("joke", jokesService.getJoke());
        return "chucknorris";
    }
}
