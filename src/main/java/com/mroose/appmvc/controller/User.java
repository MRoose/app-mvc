package com.mroose.appmvc.controller;

import com.mroose.appmvc.model.Summary;
import com.mroose.appmvc.service.MethodsForControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class User {
    @Autowired
    private MethodsForControllers methodsForControllers;

    @GetMapping("/info")
    public String getUser(Principal principal, Model model) {
        model.addAttribute("user", methodsForControllers.getSummaryByUsername(principal.getName()));
        return "user";
    }

    @GetMapping("/update")
    public String getInfoForUpdate(Principal principal, Model model) {
        model.addAttribute("user", methodsForControllers.getSummaryByUsername(principal.getName()));
        return "user-update";
    }

    @PostMapping("/update")
    public String updateUser(Principal principal,
                             @RequestParam String fio,
                             @RequestParam String city,
                             @RequestParam String position,
                             @RequestParam Integer salary,
                             @RequestParam Integer age,
                             @RequestParam Integer experience,
                             @RequestParam LocalDate employmentDate) {
        methodsForControllers.saveSummary(new Summary(
                principal.getName(),
                fio,
                city,
                position,
                salary,
                age,
                experience,
                employmentDate
        ));
        return "redirect:/user/info";
    }

    @PostMapping("/delete")
    public String deleteUser(Principal principal) {
        methodsForControllers.deleteAccount(principal.getName());
        return "redirect:/logout";
    }
}
