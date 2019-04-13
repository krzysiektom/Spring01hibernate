package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublisher() {
        return publisherDao.getAll();
    }

    @ModelAttribute("allBooks")
    public List<Book> getAllBooks() {
        return bookDao.returnAllBooks();
    }

    @ModelAttribute("allAuthors")
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @GetMapping("/allBooks")
    public String showAllBooks() {
        return "allbooks";
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute(book);
        return "book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
//        Publisher publisher = publisherDao.getPublisherById(book.getPublisher().getId());
//        book.setPublisher(publisher);
        System.out.println(book);
        //bookDao.save(book);
        return "redirect:/books/allBooks";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute(bookDao.findById(id));
        return "book";
    }

    @PostMapping("/edit/{id}")
    public String modifyBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookDao.update(book);
        return "redirect:/books/allBooks";

    }

    @RequestMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        // book.setAuthors(new ArrayList<Author>().add(new Author()));
        bookDao.save(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    Book bookById(@PathVariable Long id) {
        return bookDao.findById(id);
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDeleteBook(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "confirmDelete";
    }

    @GetMapping("/confirmDelete/cancel")
    public String cancelDeleteBook() {
        return "redirect:/books/allBooks";

    }

    @GetMapping("/confirmDelete/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/books/allBooks";
    }


    @RequestMapping("/newBook/{title}/{rating}/{description}")
    @ResponseBody
    void saveBook(@PathVariable String title,
                  @PathVariable BigDecimal rating,
                  @PathVariable String description) {
        bookDao.save(new Book(title, rating, description));
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
