package vttp.ssf.assessment.eventmanagement.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired @Qualifier("myredis")
	private RedisTemplate<String, Event> template;

	// TODO: Task 2

	//save event into redis
	public void saveRecord(Event event) {
		template.opsForValue()
			.set(Integer.toString(event.getEventId()), event);

	}

	//returns size of the event list
	// TODO: Task 3
	public long getNumberOfEvents() {
		long size = template.opsForValue().size("events");
		return size;
	}

	//returns event object at the particular index from event list
	// TODO: Task 4
	public Event getEvent(Integer index) {
		return (Event) template.opsForList().index("events", index);

	}

}
