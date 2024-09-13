package com.example.candidate.controller;

import com.example.candidate.data.Candidate;
import com.example.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<Candidate> findAllCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Candidate> findCandidateById(@PathVariable int cid) {
        Candidate candidate = candidateService.getCandidateById(cid);
        if (candidate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);
    }

    @PutMapping("/{cid}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Integer cid, @RequestBody Candidate candidateDetails) {
        Candidate candidate = candidateService.getCandidateById(cid);
        if (candidate == null) {
            return ResponseEntity.notFound().build();
        }

        candidate.setCname(candidateDetails.getCname());
        candidate.setAge(candidateDetails.getAge());
        candidate.setExperience(candidateDetails.getExperience());
        candidate.setPrev_position(candidateDetails.getPrev_position());
        candidate.setQualifications(candidateDetails.getQualifications());

        Candidate updatedCandidate = candidateService.updateCandidate(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping(path = "/{cid}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Integer cid) {
        candidateService.deleteCandidate(cid);
        return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
    }

    @DeleteMapping("/clear")
    public void clearVotes() {
        candidateService.clearCandidates();
    }


    @GetMapping(params = "cname")
    public List<Candidate> findCandidateByName(@RequestParam String cname) {
        return candidateService.findCandidateByName(cname);
    }

    @GetMapping(params = "age")
    public List<Candidate> findCandidateByAge(@RequestParam int age) {
        return candidateService.findCandidateByAge(age);
    }
}
