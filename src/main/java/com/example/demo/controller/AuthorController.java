package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.service.AuthorNotFoundException;
import com.example.demo.service.AuthorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        Author savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }
    @GetMapping("/getAllAuthors")
    public ResponseEntity <List<Author>> getAllAuthors (){
        List<Author> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }
    @GetMapping("/getAuthorById/{id}")
    public ResponseEntity <Author> getAuthorById(@PathVariable int id){
        Author author = authorService.getAuthorById (id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping("/updateAuthor/{id}")
    public ResponseEntity <Author> updateAuthor(@PathVariable int id, @RequestBody Author author){
        Author updatedAuthor = authorService.updateAuthor (id, author);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }
    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity <Void> deleteAuthor(@PathVariable int id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<List<Book>> getBooksById(@PathVariable int id)  {
        List<Book> books = authorService.getBooksById(id);
        return ResponseEntity.ok(books);
    }
}
