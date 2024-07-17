package com.quiz.QuizService.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.QuizService.entities.Question;


//@FeignClient(value = "Question-Client", url = "https://localhost:8082")
@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
