package com.question.QuestionService.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.QuestionService.entiies.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QuestionRepository questionRepo;
	
	public QuestionServiceImpl(QuestionRepository questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}
	@Override
	public Question add(Question question) {
		
		return questionRepo.save(question);
	}

	

	@Override
	public List<Question> get() {
		// TODO Auto-generated method stub
		return questionRepo.findAll();
	}

	@Override
	public Question getOne(Long id) {
		// TODO Auto-generated method stub
		return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
	}
	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepo.findByQuizId(quizId);
	}

}
