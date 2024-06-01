package com.example.myprojects.quizapplication.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.myprojects.quizapplication.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{
 

}
