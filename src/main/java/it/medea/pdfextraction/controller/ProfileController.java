package it.medea.pdfextraction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.medea.pdfextraction.model.Profile;
import it.medea.pdfextraction.service.ProfileService;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	public ResponseEntity<List<Profile>> getAllProfiles() {
		return new ResponseEntity<List<Profile>>(profileService.allProfiles(),HttpStatus.OK);

	}
}
