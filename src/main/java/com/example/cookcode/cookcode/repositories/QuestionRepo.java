package com.example.cookcode.cookcode.repositories;

import com.example.cookcode.cookcode.entities.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepo extends JpaRepository<Questions, Long> {
    Page<Questions> findAll(Pageable pageable);
    Questions findByQuestionId(int questionId);
}
