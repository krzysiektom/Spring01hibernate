package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    PublisherRepository publisherRepository;

    /*@Autowired
    public PublisherController(PublisherDao publisherDao, PublisherRepository publisherRepository) {
        this.publisherDao = publisherDao;
        this.publisherRepository = publisherRepository;
    }*/

    @ModelAttribute("allPublishers")
    public List<Publisher> getAllPublishers() {
        return publisherDao.getAll();
    }

    @GetMapping("/allPublishers")
    public String showAllPublishers() {
        return "allPublishers";
    }

    @GetMapping("/addPublisher")
    public String showForm(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute(publisher);
        return "formPublisher";
    }

    /*@PostMapping("/addPublisher") //stara wersja bez walidatora formularza
    public String addAuthor(@ModelAttribute Publisher publisher) {
        publisherDao.save(publisher);
        return "redirect:/publishers/allPublishers";
    }*/

    @PostMapping("/addPublisher")
    public String addPublisher(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "formPublisher";
        }
        publisherDao.save(publisher);
        return "redirect:/publishers/allPublishers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute(publisherDao.get(id));
        return "formPublisher";
    }

    @PostMapping("/edit/{id}")
    public String modifyPublisher(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "formPublisher";
        }
        publisherDao.update(publisher);
        return "redirect:/publishers/allPublishers";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisherk(@PathVariable Long id) {
        publisherDao.delete(publisherDao.get(id));
        return "redirect:/publishers/allPublishers";

    }


    @GetMapping(path = "/{id}")
    @ResponseBody
    Publisher publisherById(@PathVariable Long id) {
        return publisherDao.get(id);
    }


   /* @RequestMapping("/delete/{id}")
    void deletePublisher(@PathVariable Long id) {
        publisherDao.delete(publisherDao.get(id));
    }*/

    @RequestMapping("/newPublisher/{name}")
    @ResponseBody
    void savePublisher(@PathVariable String name) {
        publisherDao.save(new Publisher(name));
    }

    @RequestMapping("/update/{name}")
    @ResponseBody
    void updatePublisher(@PathVariable String name) {
        publisherDao.update(new Publisher(name));
    }

    @GetMapping(path = "/show/{id}")
    @ResponseBody
    public String showPublisher(@PathVariable String id) {
        Publisher publisher = publisherRepository.findOne(Long.parseLong(id));
        return publisher.getName() + " " + publisher.getId();

    }

}
