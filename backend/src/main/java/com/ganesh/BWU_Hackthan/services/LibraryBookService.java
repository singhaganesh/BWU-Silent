package com.ganesh.BWU_Hackthan.services;


import com.ganesh.BWU_Hackthan.exception.APIException;
import com.ganesh.BWU_Hackthan.model.LibraryBook;
import com.ganesh.BWU_Hackthan.repository.LibraryBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryBookService {
    @Autowired
    private LibraryBookRepository bookRepository;

    public LibraryBookService(LibraryBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public LibraryBook addBook(LibraryBook book) {
        if (bookRepository.existsByTitleAndAuthor(book.getTitle(), book.getAuthor())) {
            throw new APIException("Book with the same title and author already exists.");
        }
        book.setAvailable(true);
        return bookRepository.save(book);
    }


    public List<LibraryBook> listAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    public LibraryBook borrowBook(Long id, LocalDate dueDate,Authentication authentication) {
        LibraryBook book = bookRepository.findById(id).orElseThrow();
        book.setAvailable(false);
        if (authentication != null){
            book.setBorrowedBy(authentication.getName());
        }else {
            throw new APIException("Login again");
        }

        book.setDueDate(dueDate);
        return bookRepository.save(book);
    }

    public LibraryBook returnBook(Long id) {
        LibraryBook book = bookRepository.findById(id).orElseThrow();
        book.setAvailable(true);
        book.setBorrowedBy(null);
        book.setDueDate(null);
        return bookRepository.save(book);
    }
}