package com.example.Springboot.controller;

import com.example.Springboot.entity.Book;
import com.example.Springboot.entity.BookDTO;
import com.example.Springboot.service.BookService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name="My REST API", description = "책 API 서비스이다.")
public class BookRestController {

    public final BookService bookService;

    //GET : http://localhost:8082/api/book
    @GetMapping("/book")
    public List<BookDTO> books(){

        List<BookDTO> books = bookService.getAllBooksDTO();
        return books; // JSON(MessageConverter:순환참조 문제 발생)
    }
    
    @PostMapping("/book")
    public BookDTO register(@RequestBody BookDTO dto){
        
        // 다음수업
        
        return null;
    }

}
