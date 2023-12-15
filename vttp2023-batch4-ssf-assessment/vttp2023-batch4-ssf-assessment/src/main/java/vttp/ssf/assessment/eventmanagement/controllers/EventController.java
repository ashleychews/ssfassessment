package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping(path= "/events")
public class EventController {

	@Autowired
	DatabaseService dbSvc;

	//TODO: Task 5
	@GetMapping("/listing")
	public String displayEvents(Model model) {
		model.addAttribute("event", dbSvc.retrieveList());
		return "view0";
	}


}
