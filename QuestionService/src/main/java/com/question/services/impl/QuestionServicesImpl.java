package com.question.services.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServicesImpl implements QuestionService {

    QuestionRepository questionRepository;

    public QuestionServicesImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }
    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
    }
    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }
}
