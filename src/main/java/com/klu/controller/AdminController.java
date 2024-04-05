package com.klu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.klu.repository.CandidateRepository;
import com.klu.repository.UserRepository;
import com.klu.repository.VoterRepository;

@Controller
public class AdminController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoterRepository voterRepository;

    @GetMapping("/api/candidates/count")
    @ResponseBody
    public long getCandidateCount() {
        return candidateRepository.count();
    }

    @GetMapping("/api/users/count")
    @ResponseBody
    public long getUserCount() {
        return userRepository.count();
    }

    @GetMapping("/api/voters/count")
    @ResponseBody
    public long getVoterCount() {
        return voterRepository.count();
    }
}