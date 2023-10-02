package com.library.service;

import com.library.domain.Book;
import com.library.dto.BookDTO;
import com.library.exception.ResourceNotFoundException;
import com.library.exception.message.ErrorMessage;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    
    @Autowired
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
              .map(BookService::apply).toList();
    }


    public BookDTO getBookById(Integer id) {
        return bookRepository.findById(id)
              .map(BookService::apply).orElseThrow(
                        () -> new ResourceNotFoundException(
                                String.format(ErrorMessage.BOOK_NOT_FOUND_EXCEPTION, id))
                );
    }

    private static BookDTO apply(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setYearOfPublication(book.getYearOfPublication());
        return bookDTO;
    }
}