package com.taco.demo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class HomeController implements WebMvcConfigurer {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/h2")
    public String home2() {
        return "home2";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/register")
    public String showForm(PersonForm personForm) {
        return "register";
    }

    @PostMapping("/register")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        return "redirect:/results";
    }
}
