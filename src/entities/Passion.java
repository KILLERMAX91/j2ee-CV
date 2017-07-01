package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="passion")
public class Passion {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	
	private String nom;
	
	private String description;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	
}
