package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Register;

@Controller
@RequestMapping("/events/register")
public class RegistrationController {
    

    // TODO: Task 6
    @PostMapping("/{eventId}")
    public String postRegister(@Valid @ModelAttribute("register") Register register, BindingResult result) {

        //have error return error page
        if (result.hasErrors()) {
            return "view3"; 
        }

        register.calculateAge();
        //validate age range
        if (register.getAge() < 21) {
            result.addError(new FieldError("contact", "birthDay", "Must be above 21 to participate"));
            return "ErrorRegistration"; 
        }

        return "SuccessRegistration"; //success page
    }

    // TODO: Task 7
}
