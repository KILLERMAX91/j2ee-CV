package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="enseignement")
public class Enseignement {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String nom;
	
	
	private String niveau;
	
	
	private String groupe;


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getGroupe() {
		return groupe;
	}


	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}


	public Long getId() {
		return id;
	}
	
	
	
}
