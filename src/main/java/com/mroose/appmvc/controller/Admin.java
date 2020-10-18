package com.mroose.appmvc.controller;

import com.mroose.appmvc.model.Account;
import com.mroose.appmvc.model.Summary;
import com.mroose.appmvc.service.MethodsForControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private MethodsForControllers methodsForControllers;

    @GetMapping("/list")
    public String getUserList(Model model) {
        model.addAttribute("users", methodsForControllers.getSummaryList());
        return "admin";
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "admin-add";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String role,
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
                role
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
        return "redirect:/admin/list";
    }

    @GetMapping("/get/user/{username}")
    public String getSummaryByUsername(@PathVariable String username, Model model) {
        model.addAttribute("user", methodsForControllers.getSummaryByUsername(username));
        return "admin-update";
    }

    @PostMapping("/update/user/{username}")
    public String updateSummary(@PathVariable String username,
                                @RequestParam String fio,
                                @RequestParam String city,
                                @RequestParam String position,
                                @RequestParam Integer salary,
                                @RequestParam Integer age,
                                @RequestParam Integer experience,
                                @RequestParam LocalDate employmentDate) {
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
        return "redirect:/admin/list";
    }

    @PostMapping("/delete/user/{username}")
    public String deleteUser(@PathVariable String username) {
        methodsForControllers.deleteAccount(username);
        return "redirect:/admin/list";
    }
}
