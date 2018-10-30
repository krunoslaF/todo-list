package com.krunoslav.controllers;

import com.krunoslav.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    // http://localhost:8080/ToDo/hello
    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(value="logout")
    public String logout(Model model){
        model.addAttribute("sin", "Vito Guldan zvani Buhtla");
        return "logout";
    }

    // http://localhost:8080/ToDo/welcome
    // http://localhost:8080/ToDo/welcome?user=Vito
    @RequestMapping(value="/welcome/{user}", method = RequestMethod.GET)
    public String welcomeUser(@PathVariable("user") String user, Model model){
        model.addAttribute("user",demoService.getHelloMessage(user));
        log.info("model: {}", model);
        return "welcomeUser";
    }

    @RequestMapping(value="welcome", method= RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("helloMessage","Dobar dan, doobrodošli...");
        return "welcome";
    }


    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called...");
        return demoService.getWelcomeMessage();
    }

    @ModelAttribute("goodbyeMessage")
    public String neobicnoImeMetode(){
        log.info("Zovem metodu neobicnoImeMetode koja printa goodbyeMessage atribut iz modela...");
        return "Bye bye, Butters... Bye bye!";
    }



}
