package com.chg.ticketing_system.config;

import com.chg.ticketing_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private AdminService adminService;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Initializing Database ===");
        adminService.createDefaultAdmin();
        System.out.println("✅ Database initialization complete");
    }
}