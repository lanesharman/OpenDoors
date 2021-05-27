package com.opendoors.landmanagement.controller;


import javax.servlet.http.HttpServletRequest;

import com.opendoors.landmanagement.domain.User;
import com.opendoors.landmanagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private String name;
    private String code;

    @GetMapping(value = "/")
    public String showIndex(Model model, HttpServletRequest request) {
        String host = request.getHeader("host");
        if(host.indexOf(".") < 0){
            name = "local";
        }else{
            name = host.substring(0, host.indexOf("."));
        }
        model.addAttribute("userName", name);
       
        return "index";
    }
 
    @PostMapping(value = "/")
    public String submitIndex(Model model, HttpServletRequest request, @ModelAttribute("code") String code) {        
        try {
            String host = request.getHeader("host");
            if(host.indexOf(".") < 0){
                name = "local";
            }else{
                name = host.substring(0, host.indexOf("."));
            }
            model.addAttribute("userName", name);
            userService.checkCode(code);
            this.code = code;
            return "redirect:/form";
        } catch (Exception ex) {
            // log exception first, 
            // then show error
            String errorMessage = ex.getMessage();            
            // logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "index";
        }        
    }

    @GetMapping(value = "/form")
    public String showForm(Model model, HttpServletRequest request) {
        return "form";
    }
 
    @PostMapping(value = "/form")
    public String submitForm(Model model, HttpServletRequest request, @ModelAttribute("user") User user, @RequestParam("status") String status) {        
        try {
            String host = request.getHeader("host");
            if(host.indexOf(".") < 0){
                name = "local";
            }else{
                name = host.substring(0, host.indexOf("."));
            }
            user.setName(name);
            user.setStatus(status);
            user.setCode(this.code);
            userService.checkUser(user);
            return "redirect:/thank";
        } catch (Exception ex) {
            // log exception first, 
            // then show error
            String errorMessage = ex.getMessage();            
            // logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "form";
        }        
    }

    @GetMapping(value = {"/thank"})
    public String showThankYou(Model model) {
        return "thank";
    }

    @GetMapping(value = {"/test"})
    public String showTestFile(Model model, HttpServletRequest request){
        String host = request.getHeader("host");
        if(host.indexOf(".") < 0){
            name = "local";
        }else{
            name = host.substring(0, host.indexOf("."));
        }
        model.addAttribute("name", this.name);
        return "testfile";
    }

}
