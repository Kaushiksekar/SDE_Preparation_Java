package com.tutorials.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "", "index", "index.html"}) // list of things that might be in the url
    public String index(){
        return "index";
    }

}
