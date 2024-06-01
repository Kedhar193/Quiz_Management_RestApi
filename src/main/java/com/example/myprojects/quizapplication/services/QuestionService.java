package com.example.myprojects.quizapplication.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;

import com.example.myprojects.quizapplication.Question;
import com.example.myprojects.quizapplication.dao.QuestionDao;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questiondao;

    public List<Question> getAllQuestions() {
        System.out.println("inside Questionservice get all questions method");
        return questiondao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questiondao.getQuestionsBycategory(category);
    }

    public String addQuestion(Question question) {
        try {
            questiondao.save(question);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException("Failed to add question", e);
        }
    }
}
 