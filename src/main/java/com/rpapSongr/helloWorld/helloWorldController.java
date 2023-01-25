package com.rpapSongr.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloWorldController {
    //routes and logic ges here
    @ResponseBody
    @GetMapping("/hello")
    public String getHome() {
        return "hello world!";
    }

    @GetMapping("/")
    public String getHello(Model m) {
        //Model() This is how we send data to out thymeleaf templates
        m.addAttribute("name", "Ryan");
        return "hello";
    }

    //URL parameters is 1 one way we GET data from out view
    @ResponseBody
    @GetMapping("/speak/{word}")
    public String speak(@PathVariable String word) {
        return word;
    }

    @ResponseBody
    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable String word) {
        return word.toUpperCase();
    }

    @ResponseBody
    @GetMapping("/albums") {
        public String albumData (Model m){
            Album album1 = new Album();
            Album album2 = new Album();
            Album album3 = new Album();
        }
    }
