package com.klu.entity;

public class VoteRequest {
    private String voterId;
    private String candidateId;
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public VoteRequest(String voterId, String candidateId) {
		super();
		this.voterId = voterId;
		this.candidateId = candidateId;
	}

    // Constructors, getters, and setters
}
