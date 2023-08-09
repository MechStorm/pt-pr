package com.example.spring_boot_exp.service;

import com.example.spring_boot_exp.model.Book;
import com.example.spring_boot_exp.model.Image;
import com.example.spring_boot_exp.model.User;
import com.example.spring_boot_exp.repositories.BookRepository;
import com.example.spring_boot_exp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceBook {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public List<Book> getAllBooks(String title) {
        if (title != null) return bookRepository.findBookByTitle(title);
        return bookRepository.findAll();
    }

    public void saveBook(Principal principal, Book book, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        book.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            book.addImageToBook(image1);
        }

        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            book.addImageToBook(image2);
        }

        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            book.addImageToBook(image3);
        }

        log.info("Saving new book. Title: {}, Author: {}, User: {}", book.getTitle(), book.getAuthor(), book.getUser().getEmail());
        Book bookFromDB = bookRepository.save(book);
        bookFromDB.setPreviewImageID(bookFromDB.getImages().get(0).getId());
        bookRepository.save(book);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }

    public void deleteBook(long id) {
        log.info("delete book with id {}", id);
        bookRepository.deleteById(id);
    }

    public Book getBookByID(long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
