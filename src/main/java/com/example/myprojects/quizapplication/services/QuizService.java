package com.example.myprojects.quizapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.myprojects.quizapplication.Question;
import com.example.myprojects.quizapplication.QuestionWrapper;
import com.example.myprojects.quizapplication.Quiz;
import com.example.myprojects.quizapplication.Response;
import com.example.myprojects.quizapplication.dao.QuestionDao;
import com.example.myprojects.quizapplication.dao.QuizDao;

@Service
public class QuizService {
    @Autowired
	QuizDao quizdao;
    @Autowired
    QuestionDao questiondao;
	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		List<Question> questions=questiondao.findRandomQuestionsByCategory(category,numq);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizdao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz=quizdao.findById(id);
       List<Question> questionsfromDB=quiz.get().getQuestions();
       List<QuestionWrapper> questionsforUser=new ArrayList<>();
       for(Question q : questionsfromDB) {
    	   QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionDescription(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
    	   questionsforUser.add(qw);
       }
       return new ResponseEntity<>(questionsforUser,HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
	Quiz quiz=quizdao.findById(id).get();
	List<Question> questions=quiz.getQuestions();
	int right=0;
	int i=0;
	for(Response responses : response) {
		if(responses.getResponse().equals(questions.get(i).getCorrectOption())) {
		right++;
		}
		i++;
	}
	
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	
}
