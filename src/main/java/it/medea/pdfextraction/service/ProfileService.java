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
}
