package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/persons")
public class PersonDetailsController {
    PersonDetailsDao personDetailsDao;
    ProgrammingSkillDao programmingSkillDao;
    HobbyDao hobbyDao;

    @Autowired
    public PersonDetailsController(PersonDetailsDao personDetailsDao, ProgrammingSkillDao programmingSkillDao, HobbyDao hobbyDao) {
        this.personDetailsDao = personDetailsDao;
        this.programmingSkillDao = programmingSkillDao;
        this.hobbyDao = hobbyDao;
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Person person = new Person();
        PersonDetails personDetails = new PersonDetails();
        model.addAttribute("personDetails", personDetails);
        return "personDetails";
    }

    @PostMapping("/showForm")
    @ResponseBody
    public String addPersonDetails(@ModelAttribute PersonDetails personDetails) {
        System.out.println(personDetails.getProgrammingSkills());
        System.out.println(personDetails.getHobbies());
        List<ProgrammingSkill> programmingSkills;
        programmingSkills = personDetails.getProgrammingSkills().stream()
                .map(programmingSkill -> programmingSkillDao.get(Long.parseLong(programmingSkill.getSkill())))
                .collect(Collectors.toList());
        personDetails.setProgrammingSkills(programmingSkills);
        System.out.println(personDetails.getProgrammingSkills());
        System.out.println(personDetails.getHobbies());
        personDetailsDao.save(personDetails);
        return personDetails.toString();
    }

    @ModelAttribute("countries")
    public Collection<String> countries() {
        List<String> countries = new ArrayList<>();
        countries.add("Polska");
        countries.add("Niemcy");
        countries.add("Czechy");
        return countries;
    }


    @ModelAttribute("programmingSkills")
    public List<ProgrammingSkill> programmingSkills() {
        return programmingSkillDao.getAll();
    }

    @ModelAttribute("hobbies")
    public Collection<Hobby> hobbies() {
        return hobbyDao.getAll();
    }
}
