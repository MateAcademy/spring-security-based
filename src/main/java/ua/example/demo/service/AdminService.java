package ua.example.demo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String doAdminStuff() {
        System.out.println("Only admin here");
        return "/auth/admin";
    }

}
