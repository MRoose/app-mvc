package com.mroose.appmvc.controller;

import com.mroose.appmvc.model.Account;
import com.mroose.appmvc.model.Summary;
import com.mroose.appmvc.service.MethodsForControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class Registration {
    @Autowired
    private MethodsForControllers methodsForControllers;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String fio,
                          @RequestParam String city,
                          @RequestParam String position,
                          @RequestParam Integer salary,
                          @RequestParam Integer age,
                          @RequestParam Integer experience,
                          @RequestParam LocalDate employmentDate) {
        methodsForControllers.saveAccount(new Account(
                username,
                password,
                "USER"
        ));
        methodsForControllers.saveSummary(new Summary(
                username,
                fio,
                city,
                position,
                salary,
                age,
                experience,
                employmentDate
        ));
        return "redirect:/logout";
    }
}
