package com.example.cookcode.cookcode.repositories;

import com.example.cookcode.cookcode.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Long> {
}
