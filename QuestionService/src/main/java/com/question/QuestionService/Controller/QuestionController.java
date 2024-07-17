package com.question.QuestionService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.entiies.Question;
import com.question.QuestionService.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;
	
	
	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}

	@PostMapping("/add")
	public Question add(@RequestBody Question question) {
		return questionService.add(question);
	}
	
	@GetMapping("/getAll")
	public List<Question> getAll(){
		return questionService.get();
	}
	
	@GetMapping("/getById/{questionId}")
	public Question getById(@PathVariable Long questionId){
		return questionService.getOne(questionId);
	}
	
	//get all question of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
		return questionService.getQuestionOfQuiz(quizId);
		
	}
}
