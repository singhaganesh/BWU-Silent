package com.ganesh.BWU_Hackthan.controller;


import com.ganesh.BWU_Hackthan.model.LibraryBook;
import com.ganesh.BWU_Hackthan.services.LibraryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/library")
@CrossOrigin(origins = "*")
public class LibraryBookController {
    @Autowired
    private LibraryBookService service;

    @PostMapping("/add")
    public LibraryBook add(@RequestBody LibraryBook book) {
        return service.addBook(book);
    }

    @GetMapping("/available")
    public List<LibraryBook> listAvailable() {
        return service.listAvailableBooks();
    }

    @PutMapping("/borrow/{id}")
    public LibraryBook borrow(@PathVariable Long id, @RequestParam String dueDate, Authentication authentication) {
        return service.borrowBook(id, LocalDate.parse(dueDate),authentication);
    }

    @PutMapping("/return/{id}")
    public LibraryBook returnBook(@PathVariable Long id) {
        return service.returnBook(id);
    }
}

