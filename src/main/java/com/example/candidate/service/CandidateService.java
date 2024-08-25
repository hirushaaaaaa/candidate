package com.example.candidate.service;

import com.example.candidate.data.Candidate;
import com.example.candidate.data.CandidateRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(int cid){
        Optional<Candidate> candidate = candidateRepository.findById(cid);
        if(candidate.isPresent()){
            return candidate.get();
        }
        return null;
    }
    public Candidate addCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(int cid){
        candidateRepository.deleteById(cid);
    }

    public List<Candidate> findCandidateByName(String cname){
        return candidateRepository.findCandidateByCname(cname);
    }
    public List<Candidate> findCandidateByAge(int age){
        return candidateRepository.findCandidateByAge(age);
    }
}
