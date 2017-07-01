package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="coordonner")
public class Coordonnees {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String mail;
	
	private String nom;
	
	@Temporal(TemporalType.DATE)
	private Date naissance;
	
	
	private boolean permis;
	
	private String networks;
	
	
	

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public boolean getPermis() {
		return permis;
	}

	public void setPermis(boolean permis) {
		this.permis = permis;
	}

	public String getNetworks() {
		return networks;
	}

	public void setNetworks(String networks) {
		this.networks = networks;
	}

	public Long getId() {
		return id;
	}
	
}
