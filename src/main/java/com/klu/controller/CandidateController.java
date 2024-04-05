package com.klu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.klu.entity.Candidate;
import com.klu.repository.CandidateRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    // POST method to insert a candidate with an image
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insertCandidate(
            @RequestParam("candidateName") String candidateName,
            @RequestParam("candidatePosition") String candidatePosition,
            @RequestParam("candidateParty") String candidateParty,
            @RequestParam("candidateManifestos") String candidateManifestos,
            @RequestParam("candidImage") MultipartFile candidImage
    ) throws IOException {
        // Validate the candidate data here if needed

        // Create a new Candidate object
        Candidate candidate = new Candidate();
        candidate.setCandidateName(candidateName);
        candidate.setCandidatePosition(candidatePosition);
        candidate.setCandidateParty(candidateParty);
        candidate.setCandidateManifestos(candidateManifestos);

        // Set the image data
        candidate.setCandidImage(candidImage.getBytes());

        // Save the candidate to the database
        Candidate savedCandidate = candidateRepository.save(candidate);

        // Return a response with the saved candidate's details
        return ResponseEntity.ok(savedCandidate);
    }

    // GET method to retrieve all candidates
    @GetMapping
    @ResponseBody
    public List<Candidate> getAllCandidates() {
    	List<Candidate> candidates = candidateRepository.findAll();
        return candidates;
    }
}
