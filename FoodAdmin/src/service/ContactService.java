package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Contact;
import modelDao.ContactModel;

@Service
public class ContactService {
	@Autowired
	private ContactModel QuestionModel;

	public List<Contact> getAllQuestions() {
		// TODO Auto-generated method stub
		return QuestionModel.getAllQuestions();
	}

	public boolean addQuestion(Contact Question) {
		// TODO Auto-generated method stub
		return QuestionModel.addQuestion(Question);
	}

	public boolean updateQuestion(Contact Question) {
		// TODO Auto-generated method stub
		return QuestionModel.updateQuestion(Question);
	}

	public boolean deleteQuestion(int QuestionId) {
		// TODO Auto-generated method stub
		return QuestionModel.deleteQuestion(QuestionId);
	}

	public Contact findQuestionById(int QuestionId) {
		// TODO Auto-generated method stub
		return QuestionModel.findQuestionById(QuestionId);
	}
}

