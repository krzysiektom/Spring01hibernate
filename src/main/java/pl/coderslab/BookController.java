package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;


    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublisher() {
        return publisherDao.returnAllPublishers();
    }

    @ModelAttribute("allBooks")
    public List<Book> getAllBooks() {
        return bookDao.returnAllBooks();
    }

    @GetMapping("/allBooks")
    public String showAllBooks() {
        return "allbooks";
    }


    @RequestMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        // book.setAuthors(new ArrayList<Author>().add(new Author()));
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

    @RequestMapping("/newBook/{title}/{rating}/{description}")
    @ResponseBody
    void saveBook(@PathVariable String title,
                  @PathVariable BigDecimal rating,
                  @PathVariable String description) {
        bookDao.saveBook(new Book(title, rating, description));
    }

    @RequestMapping("/update/{title}/{rating}/{description}")
    @ResponseBody
    void updateBook(
            @PathVariable String title,
            @PathVariable BigDecimal rating,
            @PathVariable String description) {
        bookDao.update(new Book(title, rating, description));
    }
}
