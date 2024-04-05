package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klu.entity.Voter;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    Optional<Voter> findByVoterId(String voterId);
    
    @Query("SELECT v.candidateId, COUNT(v) FROM Voter v GROUP BY v.candidateId")
    List<Object[]> countVotesPerCandidate();
}
