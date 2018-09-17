package org.verscend.bbplus.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.Event;
import org.verscend.bbplus.repository.EventRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventResource {

	@Autowired
	EventRepository eventRepository;

	@RequestMapping(value = "events", method = RequestMethod.GET)
	public List<Event> getEvents() {
		List<Event> eventList = new ArrayList<>();
		eventRepository.findAll().forEach(eventList::add);
		return eventList;
	}

	@PostMapping("saveEvent")
	public void save(@RequestBody Event event) {
		eventRepository.save(event);
	}

	@DeleteMapping("events/{eventId}")
	public void deleteEvent(@PathVariable int eventId) {
		eventRepository.deleteById(eventId);
	}

	@PutMapping("updateEvent")
	public void updateEvent(@RequestBody Event event) {
		eventRepository.save(event);
	}

}
