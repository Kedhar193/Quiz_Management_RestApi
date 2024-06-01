 package com.example.myprojects.quizapplication.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myprojects.quizapplication.QuestionWrapper;
import com.example.myprojects.quizapplication.Response;
import com.example.myprojects.quizapplication.services.QuizService;
@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizservice;
    @PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){

    	return quizservice.createQuiz(category,numq ,title);
		
	}
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
    	return quizservice.getQuizQuestions(id);
    }
	@PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizservice.calculateResult(id,response);
	}
}
