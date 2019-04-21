package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ValidationController {

    private Validator validator;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;
    private BookDao bookDao;

    @Autowired
    public ValidationController(Validator validator, PublisherDao publisherDao, AuthorDao authorDao, BookDao bookDao) {
        this.validator = validator;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublisher() {
        return publisherDao.getAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @GetMapping("/validateBook")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setRating(new BigDecimal(30));
        book.setPublisher(new Publisher());
        Set<ConstraintViolation<Book>> violations = validator.validate(book, ValidationBook.class);
        List<String> strings = new ArrayList<>(); //zamienieć na parę klucz wartość
        for (ConstraintViolation<Book> constraintViolation : violations) {
            strings.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        }
        model.addAttribute("violations", strings);
        if (!violations.isEmpty()) { //sprawdzenie czy wystąpiły błędy
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        }
        return "validateBook";
    }

    @GetMapping("/validateAuthor")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setEmail("sdasda");
        author.setFirstName("sdas");
        author.setPESEL("123");
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        List<String> strings = new ArrayList<>(); //zamienieć na parę klucz wartość
        for (ConstraintViolation<Author> constraintViolation : violations) {
            strings.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        }
        model.addAttribute("violations", strings);
        if (!violations.isEmpty()) { //sprawdzenie czy wystąpiły błędy
            for (ConstraintViolation<Author> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        }
        return "validateAuthor";
    }

    @GetMapping("/validatePublisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setNIP("asda");
        publisher.setREGON("656");
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        // Map<String,String> errorMap = violations.stream().collect(Collectors.toMap(cv->cv.getPropertyPath(),cv->cv.getMessage()));

        List<String> strings = new ArrayList<>(); //zamienieć na parę klucz wartość
        for (ConstraintViolation<Publisher> constraintViolation : violations) {
            strings.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        }
        model.addAttribute("violations", strings);
        if (!violations.isEmpty()) { //sprawdzenie czy wystąpiły błędy
            for (ConstraintViolation<Publisher> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        }
        return "validatePublisher";
    }

    @GetMapping("/validateBookForm")
    public String validateFormShow(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/validateBookForm")
    public String validateForm(@ModelAttribute("book") @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        bookDao.save(book);
        return "redirect:/books/allBooks";
    }

}

