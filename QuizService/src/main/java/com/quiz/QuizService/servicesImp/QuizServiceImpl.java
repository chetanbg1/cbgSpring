package com.quiz.QuizService.servicesImp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepo;
	//@Autowired
	private QuestionClient questionClient;
	
	

	public QuizServiceImpl(QuizRepository quizRepo, QuestionClient questionClient) {
		super();
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = quizRepo.findAll();
		List<Quiz> newQuizList   = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		//return quizRepo.findAll();
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(()-> new RuntimeException("not found.."));
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
		return quiz;
	}

}
