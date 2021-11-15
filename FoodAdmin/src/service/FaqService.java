package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Faq;
import modelDao.FaqModel;

@Service
public class FaqService {
	@Autowired
	private FaqModel FaqModel;

	public List<Faq> getAllFaqs() {
		// TODO Auto-generated method stub
		return FaqModel.getAllFaqs();
	}

	public boolean addFaq(Faq Faq) {
		// TODO Auto-generated method stub
		return FaqModel.addFaq(Faq);
	}

	public boolean updateFaq(Faq Faq) {
		// TODO Auto-generated method stub
		return FaqModel.updateFaq(Faq);
	}

	public boolean deleteFaq(int FaqId) {
		// TODO Auto-generated method stub
		return FaqModel.deleteFaq(FaqId);
	}

	public Faq findFaqById(int FaqId) {
		// TODO Auto-generated method stub
		return FaqModel.findFaqById(FaqId);
	}
}
