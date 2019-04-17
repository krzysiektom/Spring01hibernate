package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @ModelAttribute("allAuthors")
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @GetMapping("/allAuthors")
    public String showAllBooks() {
        return "allAuthors";
    }

    @GetMapping("/addAuthor")
    public String showForm(Model model) {
        Author author = new Author();
        model.addAttribute(author);
        return "formAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "formAuthor";
        }
        authorDao.save(author);
        return "redirect:/authors/allAuthors";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute(authorDao.get(id));
        return "formAuthor";
    }

    @PostMapping("/edit/{id}")
    public String modifyAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "formAuthor";
        }
        authorDao.update(author);
        return "redirect:/authors/allAuthors";

    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorDao.delete(authorDao.get(id));
        return "redirect:/authors/allAuthors";
    }


    @GetMapping(path = "/{id}")
    @ResponseBody
    Author authorById(@PathVariable Long id) {
        return authorDao.get(id);
    }

//    @RequestMapping("/delete/{id}")
//    void deleteAuthor(@PathVariable Long id) {
//        authorDao.delete(authorDao.get(id));
//    }

    @RequestMapping("/newAuthor/{firstName}/{lastName}")
    @ResponseBody
    void saveAuthor(@PathVariable String firstName,
                    @PathVariable String lastName) {
        authorDao.save(new Author(firstName, lastName));
    }

    @RequestMapping("/update/{firstName}/{lastName}")
    @ResponseBody
    void updateAuthor(
            @PathVariable String firstName,
            @PathVariable String lastName) {
        authorDao.update(new Author(firstName, lastName));
    }

}
