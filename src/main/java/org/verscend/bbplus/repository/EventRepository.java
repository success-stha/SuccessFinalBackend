package org.verscend.bbplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
