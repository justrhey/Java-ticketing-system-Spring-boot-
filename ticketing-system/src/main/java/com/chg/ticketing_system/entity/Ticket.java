package com.chg.ticketing_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(length = 1000)
    private String description;
    
    private String status = "OPEN"; // OPEN, IN_PROGRESS, RESOLVED, CLOSED
    private String priority = "MEDIUM"; // LOW, MEDIUM, HIGH, CRITICAL
    private String createdBy;
    private String assignedTo;
    
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    
    // Default constructor
    public Ticket() {}
    
    // Constructor for easy creation
    public Ticket(String title, String description, String createdBy) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters (generate these or write manually)
    public Long getId() { 
        return id;
         }
    public void setId(Long id) { 
        this.id = id;
         }
    public String getTitle() { 
        return title;
         }
    public void setTitle(String title) {
         this.title = title; 
         }
    public String getDescription() { 
        return description;
         }
    public void setDescription(String description) { 
        this.description = description;
         }
    public String getStatus() {
         return status;
          }
    public void setStatus(String status) {
         this.status = status; 
         }
    public String getPriority() {
         return priority; 
         }
    public void setPriority(String priority) {
         this.priority = priority;
          }
    public String getCreatedBy() { 
        return createdBy; 
        }
    public void setCreatedBy(String createdBy) { 
        this.createdBy = createdBy; 
        }
    public String getAssignedTo() { 
        return assignedTo; 
        }
    public void setAssignedTo(String assignedTo) { 
        this.assignedTo = assignedTo;
         }
    public LocalDateTime getCreatedAt() { 
        return createdAt; 
        }
    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt;
         }
    public LocalDateTime getUpdatedAt() {
         return updatedAt;
          }
    public void setUpdatedAt(LocalDateTime updatedAt) { 
        this.updatedAt = updatedAt;
         }
}