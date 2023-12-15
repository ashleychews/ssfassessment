package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Controller
@RequestMapping(path= "/events")
public class EventController {

	//TODO: Task 5
	@GetMapping("/listing")
	public String displayEvents(Model model) {
		model.addAttribute("event", new Event());
		return "view0";
	}

	@GetMapping("/register/{eventId}")
	public String register() {
		return "view1";
	}

}
