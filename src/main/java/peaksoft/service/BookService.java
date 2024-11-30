package peaksoft.service;

import peaksoft.entity.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);
    List<Book> findAll();
    Book findById(Long id);


    // delete

    // update

    // sord asc and desk


//    void findByBookName(String bookName);




}
