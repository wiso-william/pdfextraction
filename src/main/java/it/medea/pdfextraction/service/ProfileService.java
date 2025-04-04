package it.medea.pdfextraction.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.medea.pdfextraction.model.Profile;
import it.medea.pdfextraction.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> allProfiles() {
		return profileRepository.findAll();
	}
	
	public Optional<Profile> singleProfile(ObjectId id) {
		return profileRepository.findById(id);
	}
	
	public Profile createProfile(Profile profile) {
	    return profileRepository.save(profile);
	}
	
	// ProfileService.java
	public Profile updateProfile(ObjectId id, Profile updatedProfile) {
	    // Verifica se il profilo esiste
	    Profile existingProfile = profileRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Profilo non trovato con ID: " + id));
	    
	    // Aggiorna solo i campi modificabili
	    existingProfile.setName(updatedProfile.getName());
	    existingProfile.setSurname(updatedProfile.getSurname());
	    existingProfile.setCodiceFiscale(updatedProfile.getCodiceFiscale());
	    existingProfile.setBirthDate(updatedProfile.getBirthDate());
	    existingProfile.setSex(updatedProfile.getSex());
	    
	    return profileRepository.save(existingProfile);
	}
}
