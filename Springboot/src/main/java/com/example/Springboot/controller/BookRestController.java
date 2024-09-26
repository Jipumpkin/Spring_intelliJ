package com.example.Springboot.controller;

import com.example.Springboot.entity.Book;
import com.example.Springboot.entity.BookDTO;
import com.example.Springboot.entity.BookPayloadDTO;
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

    //등록용
    @PostMapping("/book")
    public BookDTO register(@RequestBody BookPayloadDTO dto){
            Book book = new Book(); // Table로 인식함(엔티티)
            BookDTO view = new BookDTO();
        try {
            book.setTitle(dto.getTitle());
            book.setPrice(dto.getPrice());
            book.setAuthor(dto.getAuthor());
            book.setPage(dto.getPage());
            book = bookService.save(book); //등록 후 등록된 book반환

            // BookDTO(응답용)를 사용
            view.setId(book.getId());
            view.setTitle(book.getTitle());
            view.setAuthor(book.getAuthor());
            view.setPrice(book.getPrice());
            view.setPage(book.getPage());

        }catch (Exception e){
            e.printStackTrace();
        }
        
        return view;
    }

}
