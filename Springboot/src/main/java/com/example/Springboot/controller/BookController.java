package com.example.Springboot.controller;

import com.example.Springboot.entity.Book;
import com.example.Springboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        return "list";
    }
}
