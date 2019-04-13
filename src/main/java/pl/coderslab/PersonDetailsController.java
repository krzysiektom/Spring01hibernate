package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonDetailsController {
    @GetMapping("/showForm")
    public String showForm(Model model){
        Person person = new Person();
        PersonDetails personDetails = new PersonDetails();
        model.addAttribute("person", person);
        model.addAttribute("personDetails",personDetails);
        return "personDetails";
    }
}
