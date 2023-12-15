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
        try {
            List<Event> events = dbSvc.readFile(pathFilename);
            // Do something with the events, e.g., print them
            events.forEach(System.out::println);
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
	}

}
//jakarta.json.stream.JsonParsingException: Unexpected char 67 at (line no=1, column no=1, offset=0)