package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="formation")
public class Formation {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="nom_form")
	private String nomForm;
	
	private int duree;
	
	@Temporal(TemporalType.DATE)
	private Date annee;
	
	private String description;
	
	private String lieu;
	
	private String diplome;

	public String getNomForm() {
		return nomForm;
	}

	public void setNomForm(String nomForm) {
		this.nomForm = nomForm;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
