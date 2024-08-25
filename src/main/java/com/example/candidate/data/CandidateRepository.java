package com.example.candidate.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

    List<Candidate> findCandidateByName(String cname);

    List<Candidate> findCandidateByAge(int age);
}
