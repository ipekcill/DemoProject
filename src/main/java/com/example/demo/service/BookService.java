package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public  List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public Book updateBook(int id,Book book) {
        Book oldBook = getBookById(id);
        oldBook.setName(book.getName());
        return bookRepository.save(oldBook);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
