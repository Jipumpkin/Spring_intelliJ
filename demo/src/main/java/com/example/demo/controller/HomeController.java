package com.example.demo.controller;

import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final BookService bookService;

    // http://localhost:8081/home
    @GetMapping("/home")
    public String home() {
        return "home"; // home.html
    }


    @GetMapping("/list")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list"; // list.html
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){

        bookService.deleteById(id);

        return "redirect:/list";
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/register")
    public String register(Book book){
        bookService.save(book);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail"; // detail.html
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "modify"; // modify.html
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id,  Book book){ // book.id(2) --> Table(2)
        bookService.update(book);
        return "redirect:/list";
    }
}
