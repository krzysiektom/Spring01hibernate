package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    Book bookById(@PathVariable Long id) {
        return bookDao.findById(id);
    }

    @RequestMapping("/delete/{id}")
    void deleteBook(@PathVariable Long id) {
        bookDao.delete(bookDao.findById(id));
    }

    @RequestMapping("/newBook/{title}/{author}/{rating}/{publisher}/{description}")
    @ResponseBody
    void saveBook(@PathVariable String title,
                  @PathVariable String author,
                  @PathVariable BigDecimal rating,
                  @PathVariable String publisher,
                  @PathVariable String description) {
        bookDao.saveBook(new Book(title, author, rating, publisher, description));
    }

    @RequestMapping("/update/{title}/{author}/{rating}/{publisher}/{description}")
    @ResponseBody
    void updateBook(
            @PathVariable String title,
            @PathVariable String author,
            @PathVariable BigDecimal rating,
            @PathVariable String publisher,
            @PathVariable String description) {
        bookDao.update(new Book(title, author, rating, publisher, description));
    }
}
