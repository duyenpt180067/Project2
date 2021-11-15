package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Bonus;
import modelDao.BonusModel;

@Service
public class BonusService {
	@Autowired
	private BonusModel BonusModel;

	public List<Bonus> getAllBonuss() {
		// TODO Auto-generated method stub
		return BonusModel.getAllBonuss();
	}

	public boolean addBonus(Bonus Bonus) {
		// TODO Auto-generated method stub
		return BonusModel.addBonus(Bonus);
	}

	public boolean updateBonus(Bonus Bonus) {
		// TODO Auto-generated method stub
		return BonusModel.updateBonus(Bonus);
	}

	public boolean deleteBonus(int BonusId) {
		// TODO Auto-generated method stub
		return BonusModel.deleteBonus(BonusId);
	}

	public Bonus findBonusById(int BonusId) {
		// TODO Auto-generated method stub
		return BonusModel.findBonusById(BonusId);
	}
}

