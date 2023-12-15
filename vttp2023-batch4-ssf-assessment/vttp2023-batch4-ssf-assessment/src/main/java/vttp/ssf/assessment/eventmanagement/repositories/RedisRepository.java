package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired @Qualifier("myredis")
	private RedisTemplate<String, Event> template;

	private List<Event> events;

	// TODO: Task 2
	// public String serializeEvent(Event event) {
	// 	String eventId = Integer.toString(event.getEventId());
	// 	String eventName = event.getEventName();
	// 	String eventSize = Integer.toString(event.getEventSize());
	// 	String eventDate = Long.toString(event.getEventDate());
	// 	String participants = Integer.toString(event.getParticipants());
	// 	//build the string event for redis input
	// 	StringBuilder sb =new StringBuilder()
	// 						.append("eventId" + eventId+",")
	// 						.append("eventName"+eventName+",")
	// 						.append("eventSize"+eventSize+",")
	// 						.append("eventDate"+eventDate+",")
	// 						.append("participants"+participants+",");

	// 	String body = sb.toString();
	// 	return body;
	// }

	//save event into redis
	public void saveRecord(Event event) {
		template.opsForValue()
			.set(Integer.toString(event.getEventId()), event);

	}

	//returns size of the event list
	// TODO: Task 3
	public long getNumberOfEvents() {
		long size = template.opsForValue().size(null);
		return size;
	}

	//returns event object at the particular index from event list
	// TODO: Task 4
	public void getEvent(Integer index) {
		if (index >= 0 && index < events.size()) {
			Event desired = events.get(index);
			System.out.println("Event at index " + index + ": " + desired);
		} else {
			System.out.println("invalid index");
		}

	}

}
