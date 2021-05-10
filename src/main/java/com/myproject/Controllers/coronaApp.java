package com.myproject.Controllers;

import com.google.gson.Gson;
import com.myproject.Pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class coronaApp {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Home home;
    @Autowired
    Hello hello;
    @Autowired
    Home home1;

    @Autowired
    Hello hello1;
    @GetMapping("/myhome")
    public String home(Model m)
    {
//        String url="https://api.covid19api.com/summary";
//      String c=  restTemplate.getForObject(url,String.class);
//        Gson g=new Gson();
//        Corona corona = g.fromJson(c, Corona.class);
//        Global global=corona.getGlobal();
//        Countries countries[]=corona.getCountries();
//        m.addAttribute("countries",countries);
        m.addAttribute("global",2/0);
        return "data.html";
    }
}
