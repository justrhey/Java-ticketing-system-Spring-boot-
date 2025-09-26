package com.chg.ticketing_system.controller;

import com.chg.ticketing_system.entity.Ticket;
import com.chg.ticketing_system.service.TicketService;
import com.chg.ticketing_system.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private TicketService ticketService;
    
    @Autowired
    private AdminService adminService;
    
    // GET - Admin login page
    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin-login";
    }
    
    // GET - Admin tickets page (public view)
    @GetMapping("/tickets")
    public String adminTickets(Model model, HttpSession session) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        model.addAttribute("isAdmin", session.getAttribute("adminLoggedIn") != null);
        model.addAttribute("adminEmail", session.getAttribute("adminEmail"));
        return "admin-tickets";
    }
    
    // POST - Process admin login form submission
    @PostMapping("/login")
    public String processAdminLogin(@RequestParam String email,
                                   @RequestParam String password,
                                   HttpSession session,
                                   RedirectAttributes redirectAttributes) {
        
        if (adminService.authenticate(email, password)) {
            session.setAttribute("adminLoggedIn", true);
            session.setAttribute("adminEmail", email);
            redirectAttributes.addFlashAttribute("loginSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("loginError", "Invalid email or password");
        }
        return "redirect:/admin/tickets";
    }
    
    // GET - Admin logout
    @GetMapping("/logout")
    public String adminLogout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("adminLoggedIn");
        session.removeAttribute("adminEmail");
        redirectAttributes.addFlashAttribute("logoutSuccess", true);
        return "redirect:/admin/tickets";
    }
    
    // POST - Delete ticket (admin only)
    @PostMapping("/tickets/{id}/delete")
    public String deleteTicket(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("adminLoggedIn") == null) {
            redirectAttributes.addFlashAttribute("authError", "Please log in as admin to perform this action");
            return "redirect:/admin/tickets";
        }
        
        ticketService.deleteTicket(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", true);
        return "redirect:/admin/tickets";
    }
    
    // POST - Update ticket status (admin only)
    @PostMapping("/tickets/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status, 
                              HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("adminLoggedIn") == null) {
            redirectAttributes.addFlashAttribute("authError", "Please log in as admin to perform this action");
            return "redirect:/admin/tickets";
        }
        
        Ticket ticket = ticketService.getTicketById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        ticketService.updateTicket(id, ticket);
        redirectAttributes.addFlashAttribute("updateSuccess", true);
        return "redirect:/admin/tickets";
    }
}