package org.verscend.bbplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	User findByRole(String role);
}
