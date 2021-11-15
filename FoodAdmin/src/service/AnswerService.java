package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Answer;
import modelDao.AnswerModel;

@Service
public class AnswerService {
	@Autowired
	private AnswerModel AnswerModel;

	public List<Answer> getAllAnswers() {
		// TODO Auto-generated method stub
		return AnswerModel.getAllAnswers();
	}

	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return AnswerModel.addAnswer(answer);
	}

	public boolean updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return AnswerModel.updateAnswer(answer);
	}

	public boolean deleteAnswer(int answerId) {
		// TODO Auto-generated method stub
		return AnswerModel.deleteAnswer(answerId);
	}

	public Answer findAnswerById(int answerId) {
		// TODO Auto-generated method stub
		return AnswerModel.findAnswerById(answerId);
	}
}
