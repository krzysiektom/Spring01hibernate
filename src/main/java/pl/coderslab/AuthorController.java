package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    Author authorById(@PathVariable Long id) {
        return authorDao.findById(id);
    }

    @RequestMapping("/delete/{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorDao.delete(authorDao.findById(id));
    }

    @RequestMapping("/newAuthor/{firstName}/{lastName}")
    @ResponseBody
    void saveAuthor(@PathVariable String firstName,
                  @PathVariable String lastName) {
        authorDao.saveAuthor(new Author(firstName, lastName));
    }

    @RequestMapping("/update/{firstName}/{lastName}")
    @ResponseBody
    void updateAuthor(
            @PathVariable String firstName,
            @PathVariable String lastName) {
        authorDao.update(new Author(firstName, lastName));
    }

}
