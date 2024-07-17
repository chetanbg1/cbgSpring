package com.question.QuestionService.services;

import java.util.List;

import com.question.QuestionService.entiies.Question;

public interface QuestionService {
	
	Question add(Question question);
	
	List<Question>get();
	
	Question getOne(Long id);
	
	List<Question> getQuestionOfQuiz(Long quizId);
}
