package com.ganesh.BWU_Hackthan.controller;

import com.ganesh.BWU_Hackthan.model.Complaint;
import com.ganesh.BWU_Hackthan.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*")
public class ComplaintController {
    @Autowired
    private ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public Complaint submit(@RequestBody Complaint c) {
        return service.submitComplaint(c);
    }

    @GetMapping("/all")
    public List<Complaint> all() {
        return service.getAllComplaints();
    }

    @PutMapping("/update/{id}")
    public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}