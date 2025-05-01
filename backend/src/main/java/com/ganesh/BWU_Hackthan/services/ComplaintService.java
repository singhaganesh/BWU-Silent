package com.ganesh.BWU_Hackthan.services;

import com.ganesh.BWU_Hackthan.model.Complaint;
import com.ganesh.BWU_Hackthan.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint submitComplaint(Complaint complaint) {
        complaint.setStatus("Pending");
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = complaintRepository.findById(id).orElseThrow();
        c.setStatus(status);
        return complaintRepository.save(c);
    }
}