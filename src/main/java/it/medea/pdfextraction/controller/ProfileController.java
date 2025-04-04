package it.medea.pdfextraction.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.medea.pdfextraction.model.Profile;
import it.medea.pdfextraction.service.ProfileService;


@RestController
@RequestMapping("/api/v1/profiles")
@CrossOrigin(origins = "http://localhost:5173") // Permetti richieste da React
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	public ResponseEntity<List<Profile>> getAllProfiles() {
		return new ResponseEntity<List<Profile>>(profileService.allProfiles(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Profile>> getSingleMovie(@PathVariable ObjectId id) {
		return new ResponseEntity<Optional<Profile>>(profileService.singleProfile(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
	    return new ResponseEntity<>(profileService.createProfile(profile), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Profile> updateProfile(
	    @PathVariable ObjectId id,
	    @RequestBody Profile updatedProfile
	) {
	    return ResponseEntity.ok(profileService.updateProfile(id, updatedProfile));
	}
}
