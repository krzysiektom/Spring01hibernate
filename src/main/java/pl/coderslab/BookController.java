package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublisher() {
        return publisherDao.getAll();
    }

    @ModelAttribute("allBooks")
    public List<Book> getAllBooks() {
        return bookDao.getAll();
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
    public String addBook(@Validated({ValidationBook.class}) @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookDao.save(book);
        return "redirect:/books/allBooks";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute(bookDao.get(id));
        return "book";
    }

    @PostMapping("/edit/{id}")
    public String modifyBook(@Validated({ValidationBook.class}) @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
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
    public Book bookById(@PathVariable Long id) {
        return bookDao.get(id);
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
        bookDao.delete(bookDao.get(id));
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

    @GetMapping("byTitle/{title}")
    @ResponseBody
    public List<Book> findBooksByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("byCategoryName/{category}")
    @ResponseBody
    public List<Book> findBooksByCategory(@PathVariable String category) {
        Category temp = categoryRepository.findByName(category);
        return bookRepository.findByCategory(temp);
    }

    @GetMapping("byCategoryId/{id}")
    @ResponseBody
    public List<Book> findBooksById(@PathVariable String id) {
        Category category = categoryRepository.findOne(Long.parseLong(id));
        return bookRepository.findByCategory(category);
    }

    @GetMapping("byAuthor/{author}")
    @ResponseBody
    public List<Book> findBooksByAuthor(@PathVariable String author) {
        String[] nameAuthors = author.split(" ");
        Author tempAuthor = authorRepository.getByFirstNameAndLastName(nameAuthors[0], nameAuthors[1]);
        return bookRepository.findByAuthors(tempAuthor);
    }

    @GetMapping("byPublisher/{publisher}")
    @ResponseBody
    public List<Book> findBooksByPublisher(@PathVariable String publisher) {
        Publisher tempPublisher = publisherRepository.findByName(publisher);
        return bookRepository.findByPublisher(tempPublisher);
    }

    @GetMapping("byRating/{rating}")
    @ResponseBody
    public List<Book> findBooksByRating(@PathVariable String rating) {
        return bookRepository.findByRatingGreaterThan(new BigDecimal(rating));
    }


}
