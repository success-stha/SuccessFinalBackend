package org.verscend.bbplus.resource;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.BloodRequest;
import org.verscend.bbplus.models.User;
import org.verscend.bbplus.repository.BloodRequestRepository;
import org.verscend.bbplus.repository.UserRepository;

@RestController
public class MiscController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BloodRequestRepository br;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(path = "/user/profile", method = RequestMethod.GET)
	public User getUserDetails(Principal principal) {
		return userRepository.findByEmail(principal.getName());
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/admin/profile", method = RequestMethod.GET)
	public Object getAdminDetails(Authentication authentication) {
		return authentication.getDetails();
	}

	@RequestMapping(path = "/requestRepo", method = RequestMethod.GET)
	public BloodRequest getRequestDetails(Principal principal) {
		return br.findByEmail(principal.getName());
	}
}
