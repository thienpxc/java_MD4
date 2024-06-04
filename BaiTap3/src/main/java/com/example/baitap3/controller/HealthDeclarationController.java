package com.example.baitap3.controller;

import com.example.baitap3.model.HealthDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HealthDeclarationController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("declaration", new HealthDeclaration());
        return "declaration-form";
    }

    @PostMapping("/declaration")
    public String processForm(@Valid @ModelAttribute("declaration") HealthDeclaration declaration, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "declaration-form";
        }
        session.setAttribute("declaration", declaration);  // Add the declaration object to the session
        model.addAttribute("message", "Tờ khai đã được gửi thành công.");
        return "declaration-result";
    }

    @GetMapping("/declaration-view")
    public String viewDeclaration(HttpSession session, Model model) {
        HealthDeclaration declaration = (HealthDeclaration) session.getAttribute("declaration");
        model.addAttribute("declaration", declaration);
        System.out.println(declaration);
        return "declaration-view";
    }

    @GetMapping("/update-declaration")
    public String showUpdateForm(HttpSession session, Model model) {
        HealthDeclaration declaration = (HealthDeclaration) session.getAttribute("declaration");
        if (declaration == null) {
            return "redirect:/declaration";
        }
        model.addAttribute("declaration", declaration);
        return "declaration-update";
    }

    @PostMapping("/update-declaration")
    public String processUpdate(@Valid @ModelAttribute("declaration") HealthDeclaration declaration, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "declaration-update";
        }
        session.setAttribute("declaration", declaration);  // Update the declaration object in the session
        return "redirect:/declaration-view";
    }
}
