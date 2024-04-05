package com.klu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.klu.repository.CandidateRepository;
import com.klu.repository.VoterRepository;
import com.klu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class VotingController {
    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/voting/candidates")
    @ResponseBody
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @PostMapping("/election/cast-vote")
    @ResponseBody
    public ResponseEntity<String> castVote(@RequestBody VoteRequest voteRequest) {
        Optional<Voter> existingVoter = voterRepository.findByVoterId(voteRequest.getVoterId());

        if (existingVoter.isPresent()) {
            return ResponseEntity.badRequest().body("Voter ID already exists!");
        } else {
            // Create a new voter and save it
        	System.out.println("Voter ID: " + voteRequest.getVoterId());
        	System.out.println("Candidate ID: " + voteRequest.getCandidateId());
            Voter voter = new Voter();
            voter.setVoterId(voteRequest.getVoterId());
            voter.setCandidateId(voteRequest.getCandidateId());

            try {
                voterRepository.save(voter);
                return ResponseEntity.ok("Vote cast successfully!");
            } catch (DataIntegrityViolationException e) {
                // Handle any database integrity violations
                return ResponseEntity.badRequest().body("Error casting vote.");
            }
        }
        
    }
    
    @GetMapping("/voting-data")
    @ResponseBody
    public List<CandidateVoteCount> getVoteData() {
        List<Object[]> results = voterRepository.countVotesPerCandidate();

        return results.stream()
                .map(result -> new CandidateVoteCount((String) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }
    
}
