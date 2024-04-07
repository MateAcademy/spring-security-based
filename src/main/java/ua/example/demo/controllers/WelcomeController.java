package ua.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.example.demo.service.AdminService;

@Controller
@RequestMapping()
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "/welcome";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "/auth/admin";
    }

}
