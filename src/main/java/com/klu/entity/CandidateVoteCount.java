package com.klu.entity;


public class CandidateVoteCount {
    private String candidateId;
    private Long voteCount;

    public CandidateVoteCount(String candidateId, Long voteCount) {
        this.candidateId = candidateId;
        this.voteCount = voteCount;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public Long getVoteCount() {
        return voteCount;
    }
}
