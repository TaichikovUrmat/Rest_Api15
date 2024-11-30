package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Book;
import peaksoft.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookApi {

    private final BookService bookService;

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/getById")
    public Book getBookById(@RequestParam Long bookId) {
        return bookService.findById(bookId);
    }




}
