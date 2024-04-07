package ua.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.example.demo.models.Person;
import ua.example.demo.service.AdminService;
import ua.example.demo.service.RegistrationService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final AdminService adminService;

    @Autowired
    public AuthController(RegistrationService registrationService, AdminService adminService) {
        this.registrationService = registrationService;
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registrationToDB(@ModelAttribute("person") Person person) {

        registrationService.register(person);
        return "redirect:auth/login";
    }

    @GetMapping("/admin")
    public void doAdminPage() {
        adminService.doAdminStuff();
    }

}
