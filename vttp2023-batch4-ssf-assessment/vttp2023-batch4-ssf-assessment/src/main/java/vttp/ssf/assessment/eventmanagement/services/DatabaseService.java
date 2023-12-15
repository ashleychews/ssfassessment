package vttp.ssf.assessment.eventmanagement.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    // TODO: Task 1

    public List<Event> readFile(String fileName) {

        //events.json [{}] -> read array then object 
        List<Event> events = new ArrayList<>();
        JsonReader jsonReader = Json.createReader(new StringReader(fileName));
        JsonArray jsonArray = jsonReader.readArray();

        for (JsonValue jsonValue: jsonArray) {
            JsonObject jsonObject = jsonValue.asJsonObject();

            Event event = new Event();
            event.setEventId(Integer.valueOf(jsonObject.get("eventId").toString()));
            event.setEventName(jsonObject.get("eventName").toString());
            event.setEventSize(Integer.valueOf(jsonObject.get("eventSize").toString()));
            event.setEventDate(Integer.valueOf(jsonObject.get("eventDate").toString()));
            event.setParticipants(Integer.valueOf(jsonObject.get("participants").toString()));
            events.add(event);
        }
        
        return events;

    }

    
}
