package com.example.cookcode.cookcode.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int questionId;
    String questionName;
    String description;
//    String image;
    String example;
    String difficulty;
    String postedBy;
//    Date postDate;
//    Date updateDate;
}
