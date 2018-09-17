package org.verscend.bbplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.verscend.bbplus.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		if (username.equals("admin")) {
			return User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
		}
		org.verscend.bbplus.models.User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder().username(user.getEmail()).password(passwordEncoder.encode(user.getPassword()))
				.roles("USER").build();
	}
}