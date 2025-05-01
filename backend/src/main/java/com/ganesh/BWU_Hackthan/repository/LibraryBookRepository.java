package com.ganesh.BWU_Hackthan.repository;

import com.ganesh.BWU_Hackthan.model.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
    List<LibraryBook> findByAvailable(boolean available);
    boolean existsByTitleAndAuthor(String title, String author);
}
