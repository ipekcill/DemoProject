package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity <List<Book>> getAllBooks (){
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
    @GetMapping("/getBookById/{id}")
    public ResponseEntity <Book> getBookById(@PathVariable int id){
        Book book = bookService.getBookById (id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity <Book> updateBook(@PathVariable int id, @RequestBody Book book){
        Book updatedBook = bookService.updateBook (id,book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity <Void> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
