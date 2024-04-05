package com.klu.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import javax.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table(name="candidatehel")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String candidatePosition;
    private String candidateParty;
    @Size(min = 3, message = "Manifesto must contain at least 1 character (a paragraph).")
    private String candidateManifestos;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] candidImage;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidatePosition() {
		return candidatePosition;
	}
	public void setCandidatePosition(String candidatePosition) {
		this.candidatePosition = candidatePosition;
	}
	public String getCandidateParty() {
		return candidateParty;
	}
	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}
	public String getCandidateManifestos() {
		return candidateManifestos;
	}
	public void setCandidateManifestos(String candidateManifestos) {
		this.candidateManifestos = candidateManifestos;
	}
	public byte[] getCandidImage() {
        return candidImage;
    }

    public void setCandidImage(byte[] candidImage) {
        this.candidImage = candidImage;
    }
	public Candidate() {
	
	}
	

    // getters and setters
}
