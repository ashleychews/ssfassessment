package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Register;
import vttp.ssf.assessment.eventmanagement.utility.Utils;

@Controller
@RequestMapping("/events")
public class RegistrationController {
    

    // TODO: Task 6
    @GetMapping("listing/register/{eventId}")
	public String register(Model model, @ModelAttribute("event") Event event, HttpSession sess) {
		sess.setAttribute("event", event);
		model.addAttribute("register", new Register());
		return "eventregister";
	}


    // TODO: Task 7
    @PostMapping("/registration/register")
    public String processRegistration(@Valid @ModelAttribute("register") Register register, BindingResult result, Model model, HttpSession sess) {

        //if have validation error, stay on page
        if (result.hasErrors()) {
            return "eventregister"; 
        }

        //validate age range
        if (null != Utils.checkAge(register.getDob())) {
            result.addError(new FieldError("register", "dob", "Must be above 21 to participate"));
            return "ErrorRegistration"; 
        }

        model.addAttribute("registration", register);
        return "SuccessRegistration"; //success page
    }



}
