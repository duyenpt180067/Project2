package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Size;
import modelDao.SizeModel;

@Service
public class SizeService {
	@Autowired
	private SizeModel SizeModel;

	public List<Size> getAllSizes() {
		// TODO Auto-generated method stub
		return SizeModel.getAllSizes();
	}

	public boolean addSize(Size Size) {
		// TODO Auto-generated method stub
		return SizeModel.addSize(Size);
	}

	public boolean updateSize(Size Size) {
		// TODO Auto-generated method stub
		return SizeModel.updateSize(Size);
	}

	public boolean deleteSize(int SizeId) {
		// TODO Auto-generated method stub
		return SizeModel.deleteSize(SizeId);
	}

	public Size findSizeById(int SizeId) {
		// TODO Auto-generated method stub
		return SizeModel.findSizeById(SizeId);
	}
}

