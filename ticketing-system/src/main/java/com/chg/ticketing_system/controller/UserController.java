package com.chg.ticketing_system.controller;

import com.chg.ticketing_system.entity.Ticket;
import com.chg.ticketing_system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private TicketService ticketService;
    
    // User dashboard - simple view of their tickets
    @GetMapping("/tickets")
    public String userTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "user-tickets";
    }
    
    // Show create ticket form for users
    @GetMapping("/tickets/new")
    public String showUserCreateForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "user-ticket-form";
    }
    
    // Handle ticket creation from users
    @PostMapping("/tickets")
    public String createUserTicket(@ModelAttribute Ticket ticket) {
        ticketService.createTicket(ticket);
        return "redirect:/user/tickets";
    }
    
    // User can view their ticket details (read-only)
    @GetMapping("/tickets/{id}")
    public String viewUserTicket(@PathVariable Long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found"));
        model.addAttribute("ticket", ticket);
        return "user-ticket-details";
    }
}