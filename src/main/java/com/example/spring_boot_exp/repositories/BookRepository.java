package com.example.spring_boot_exp.repositories;

import com.example.spring_boot_exp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
List<Book> findBookByTitle(String title);
}