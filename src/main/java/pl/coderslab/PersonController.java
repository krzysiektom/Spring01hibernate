package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @GetMapping("/form")
    public String showForm(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return "person";
    }


    /*@PostMapping("/form")
    @ResponseBody
    public String getFromForm(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String email,
                              Model model){
        Person person = new Person(login,password,email);
        return person.toString();
    }*/

    @PostMapping("/form")
    @ResponseBody
    public String getFromForm(@ModelAttribute Person person){
        return person.toString();
    }


}
