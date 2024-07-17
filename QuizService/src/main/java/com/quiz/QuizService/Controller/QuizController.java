package com.quiz.QuizService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	@PostMapping("/add")
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	@GetMapping("/getAll")
	public List<Quiz> getAll(){
		return quizService.get();
	}
	
	@GetMapping("/getById/{id}")
	public Quiz getById(@PathVariable Long id){
		return quizService.get(id);
	}
}
