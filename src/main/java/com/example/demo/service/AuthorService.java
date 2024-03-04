package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).get();
    }

    public Author updateAuthor(int id, Author author) {
        Author oldAuthor = getAuthorById(id);
        oldAuthor.setName(author.getName());
        return authorRepository.save(oldAuthor);
    }
    public void deleteAuthor(int id){
        authorRepository.deleteById(id);
    }


    public List<Book> getBooksById(int id)  {
        List<Book> books = authorRepository.findBooksById(id);
        return books;

       /* if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            return author.getBooks();
        } else {
            throw new AuthorNotFoundException("Author cannot found: ");
        }*/
    }
}

