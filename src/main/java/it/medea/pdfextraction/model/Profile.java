package it.medea.pdfextraction.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
	@Id
	private ObjectId id;
	
    private String name;
    
    private String surname;
    
    private String codiceFiscale;
    
    private LocalDate birthDate;  // Data di nascita (se disponibile)
    
    private Integer age;  // Età (se disponibile)
    
    private Integer statura; // in cm
    
    private Integer peso; // in kg
}
