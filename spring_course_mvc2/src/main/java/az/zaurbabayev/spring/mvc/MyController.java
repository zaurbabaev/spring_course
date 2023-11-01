package az.zaurbabayev.spring.mvc;

import jakarta.validation.Valid;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller

public class MyController {

    @RequestMapping()
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }


    @PostMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        }
        return "show-emp-details-view";
    }

}
