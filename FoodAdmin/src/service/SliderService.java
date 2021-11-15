package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Slider;
import modelDao.SliderModel;

@Service
public class SliderService {
	@Autowired
	private SliderModel SliderModel;

	public List<Slider> getAllSliders() {
		// TODO Auto-generated method stub
		return SliderModel.getAllSliders();
	}

	public boolean addSlider(Slider Slider) {
		// TODO Auto-generated method stub
		return SliderModel.addSlider(Slider);
	}

	public boolean updateSlider(Slider Slider) {
		// TODO Auto-generated method stub
		return SliderModel.updateSlider(Slider);
	}

	public boolean deleteSlider(int SliderId) {
		// TODO Auto-generated method stub
		return SliderModel.deleteSlider(SliderId);
	}

	public Slider findSliderById(int SliderId) {
		// TODO Auto-generated method stub
		return SliderModel.findSliderById(SliderId);
	}
}

