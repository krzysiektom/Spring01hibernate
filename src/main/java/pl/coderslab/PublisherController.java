package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    Publisher publisherById(@PathVariable Long id) {
        return publisherDao.findById(id);
    }

    @RequestMapping("/delete/{id}")
    void deletePublisher(@PathVariable Long id) {
        publisherDao.delete(publisherDao.findById(id));
    }

    @RequestMapping("/newPublisher/{name}")
    @ResponseBody
    void savePublisher(@PathVariable String name) {
        publisherDao.savePublisher(new Publisher(name));
    }

    @RequestMapping("/update/{name}")
    @ResponseBody
    void updatePublisher(@PathVariable String name) {
        publisherDao.update(new Publisher(name));
    }

}
