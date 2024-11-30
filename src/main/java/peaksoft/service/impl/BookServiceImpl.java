package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Book;
import peaksoft.repository.BookRepo;
import peaksoft.service.BookService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;


    @Override
    public Book save(Book book) {
       return   bookRepo.save(book);
    }


    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }


    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(()  ->  new RuntimeException("not found id "));
    }
}
