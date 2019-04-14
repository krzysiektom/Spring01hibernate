package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ValidationController {

    Validator validator;

    @Autowired
    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/testOfValidator")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("Ale");
        book.setRating(new BigDecimal(30));
        book.setPublisher(new Publisher());
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
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
}
