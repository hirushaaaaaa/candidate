package com.example.candidate.controller;

import com.example.candidate.data.Candidate;
import com.example.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping(path="/candidates")
    public List<Candidate> findAllCandidates(){
        return candidateService.getCandidates();
    }

    @GetMapping(path ="/candidates/{cid}")
    public Candidate findCandidatesById(@PathVariable int cid){
        return candidateService.getCandidateById(cid);
    }

    @PostMapping(path = "/candidates")
    public Candidate createCandidate(@RequestBody Candidate candidate){
        return candidateService.addCandidate(candidate);
    }

    @PutMapping(path = "/candidates")
    public Candidate updateCandidate(@RequestBody Candidate candidate){
        return candidateService.updateCandidate(candidate);
    }

    @DeleteMapping(path = "/candidates/{cid}")
    public void deleteCandidate(@PathVariable Integer cid){
        candidateService.deleteCandidate(cid);
    }


    @GetMapping(path = "/candidates", params = "cname")
    public List<Candidate> findCandidateByName(@RequestParam String cname){
        return candidateService.findCandidateByName(cname);
    }

    @GetMapping(path = "/candidates", params = "age")
    public List<Candidate> findCandidateByAge(@RequestParam int age){
        return candidateService.findCandidateByAge(age);
    }
}
