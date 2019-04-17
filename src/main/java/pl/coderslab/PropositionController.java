package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @PersistenceContext
    EntityManager entityManager;

    private BookDao bookDao;

    @Autowired
    public PropositionController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        Query query = entityManager.createQuery("select b from Book b where proposition=true");
        model.addAttribute("allBooks", query.getResultList());
        return "allProposition";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Book book = new Book();
        book.setProposition(true);
        model.addAttribute(book);
        return "formProposition";
    }

    @PostMapping("/add")
    public String add(@Validated({ValidationProposition.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "formProposition";
        }
        book.setProposition(true);
        bookDao.save(book);
        return "redirect:/proposition/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute(bookDao.get(id));
        return "formProposition";
    }

    @PostMapping("/edit/{id}")
    public String modify(@Validated({ValidationProposition.class}) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "formProposition";
        }
        book.setProposition(true);
        bookDao.update(book);
        return "redirect:/proposition/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(bookDao.get(id));
        return "redirect:/proposition/all";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Book show(@PathVariable Long id) {
        return bookDao.get(id);
    }

}
