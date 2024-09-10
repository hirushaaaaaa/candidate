package com.example.candidate.service;

import com.example.candidate.data.Candidate;
import com.example.candidate.data.CandidateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(int cid) {
        return candidateRepository.findById(cid).orElse(null);
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Candidate candidate) {
        if (candidateRepository.existsById(candidate.getCid())) {
            return candidateRepository.save(candidate);
        }
        return null; // or throw an exception if preferred
    }

    public void deleteCandidate(int cid) {
        if (candidateRepository.existsById(cid)) {
            candidateRepository.deleteById(cid);
        } else {
            throw new RuntimeException("Candidate not found");
        }
    }




    public List<Candidate> findCandidateByName(String cname) {
        return candidateRepository.findCandidateByCname(cname);
    }

    public List<Candidate> findCandidateByAge(int age) {
        return candidateRepository.findCandidateByAge(age);
    }

}
