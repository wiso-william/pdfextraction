package it.medea.pdfextraction.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "md_dati_estratti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
	@Id
	private ObjectId id;
	
    private String name;
    
    private String surname;
    
    private String codiceFiscale;
    
    private Date birthDate;  // Data di nascita (se disponibile)
    
    private Integer age;  // Età (se disponibile)
    
    private Integer height; // in cm
    
    private Integer weight; // in kg
    
    private String sex; // F o M
}
