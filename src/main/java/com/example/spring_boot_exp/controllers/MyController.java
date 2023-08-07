package com.example.spring_boot_exp.controllers;

import com.example.spring_boot_exp.model.Book;
import com.example.spring_boot_exp.service.ServiceBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final ServiceBook serviceBook;

    @GetMapping("/")
    public String getAllEmployees(@RequestParam(name = "title", required = false) String title, Model model) {

        List<Book> books = serviceBook.getAllBooks(title);
        model.addAttribute("allBooks", books);

        return "show-all-books";
    }

    @GetMapping("/book/{id}")
    public String getBookByID(@PathVariable long id, Model model) {

        Book book = serviceBook.getBookByID(id);
        model.addAttribute("book", book);
        model.addAttribute("images", book.getImages());
        return "book-info";
    }

    @PostMapping("/book/add")
    public String addBook(@RequestParam("file1") MultipartFile file1,
                          @RequestParam("file2") MultipartFile file2,
                          @RequestParam("file3") MultipartFile file3,
                          Book book) throws IOException {
        serviceBook.saveBook(book, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        serviceBook.deleteBook(id);
        return "redirect:/";
    }
}
