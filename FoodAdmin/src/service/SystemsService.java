package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Systems;
import modelDao.SystemsModel;

@Service
public class SystemsService {
	@Autowired
	private SystemsModel SystemsModel;

	public List<Systems> getAllSystemss() {
		// TODO Auto-generated method stub
		return SystemsModel.getAllSystemss();
	}

	public boolean addSystems(Systems Systems) {
		// TODO Auto-generated method stub
		return SystemsModel.addSystems(Systems);
	}

	public boolean updateSystems(Systems Systems) {
		// TODO Auto-generated method stub
		return SystemsModel.updateSystems(Systems);
	}

	public boolean deleteSystems(int SystemsId) {
		// TODO Auto-generated method stub
		return SystemsModel.deleteSystems(SystemsId);
	}

	public Systems findSystemsById(int SystemsId) {
		// TODO Auto-generated method stub
		return SystemsModel.findSystemsById(SystemsId);
	}
}

