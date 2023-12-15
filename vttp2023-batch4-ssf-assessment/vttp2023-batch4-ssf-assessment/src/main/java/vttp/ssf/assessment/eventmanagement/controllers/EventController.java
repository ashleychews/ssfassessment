package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Register;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping(path= "/events")
public class EventController {

	//TODO: Task 5
	@GetMapping("/listing")
	public String displayEvents(Model model) {
		model.addAttribute("event", new Event());
		return "view0";
	}

	@GetMapping("listing/register/{eventId}")
	public String register(Model model) {
		model.addAttribute("register", new Register());
		return "view1";
	}

}
