package com.chg.ticketing_system.service;

import com.chg.ticketing_system.entity.AdminUser;
import com.chg.ticketing_system.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {
    
    @Autowired
    private AdminUserRepository adminUserRepository;
    
    // Add the missing authenticate method
    public boolean authenticate(String email, String password) {
        Optional<AdminUser> adminUser = adminUserRepository.findByEmail(email);
        return adminUser.isPresent() && adminUser.get().getPassword().equals(password);
    }
    
    public void createDefaultAdmin() {
        if (!adminUserRepository.existsByEmail("admin@company.com")) {
            AdminUser defaultAdmin = new AdminUser("admin@company.com", "admin123");
            adminUserRepository.save(defaultAdmin);
            System.out.println("Default admin user created: admin@company.com / admin123");
        }
    }
    
    public Optional<AdminUser> getAdminByEmail(String email) {
        return adminUserRepository.findByEmail(email);
    }
    
    // Add this method if you need it
    public AdminUser createAdminUser(String email, String password) {
        AdminUser adminUser = new AdminUser(email, password);
        return adminUserRepository.save(adminUser);
    }
}