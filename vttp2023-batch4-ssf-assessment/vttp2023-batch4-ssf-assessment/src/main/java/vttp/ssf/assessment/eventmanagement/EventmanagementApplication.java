package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.services.DatabaseService;
import vttp.ssf.assessment.eventmanagement.models.Event;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{

	@Autowired
	private DatabaseService dbSvc;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}
	
	// TODO: Task 1
	@Override
	//checking whether can readfile

	public void run(String... args) throws Exception {
		String pathFilename = "C:\\Users\\Ashley Chew\\VTTP Course\\VTTP\\SSFassessment\\ssfassessment\\vttp2023-batch4-ssf-assessment\\vttp2023-batch4-ssf-assessment\\events.json";
        List<Event> events = dbSvc.readFile(pathFilename);

		System.out.println("events" + events);
		//printed outcome:
		//events[Event{eventId=1, eventName='"Christmas Eve Party"', eventSize=20, eventDate=1703415600000, participants=0}, 
		//Event{eventId=2, eventName='"Round Singapore Cycling"', eventSize=5, eventDate=1702857600000, participants=0}, 
		//Event{eventId=3, eventName='"Intro to SCRATCH"', eventSize=5, eventDate=1704502800000, participants=0}, 
		//Event{eventId=4, eventName='"JB Shopping !"', eventSize=5, eventDate=1699837200000, participants=0}]
	}

}