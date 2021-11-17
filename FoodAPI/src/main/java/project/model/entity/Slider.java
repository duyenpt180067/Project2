package project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Slider")
public class Slider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SliderId")
	private int sliderId;
	@Column(name="ImageURL")
	private String imageURL;
	@Column(name="SliderLink")
	private String sliderLink;
	@Column(name="SliderStatus")
	private boolean sliderStatus;
	@Column(name="Priorities")
	private int priorities;
	public int getSliderId() {
		return sliderId;
	}
	public void setSliderId(int sliderId) {
		this.sliderId = sliderId;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getSliderLink() {
		return sliderLink;
	}
	public void setSliderLink(String sliderLink) {
		this.sliderLink = sliderLink;
	}
	public boolean isSliderStatus() {
		return sliderStatus;
	}
	public void setSliderStatus(boolean sliderStatus) {
		this.sliderStatus = sliderStatus;
	}
	public int getPriorities() {
		return priorities;
	}
	public void setPriorities(int priorities) {
		this.priorities = priorities;
	}
	public Slider(int sliderId, String imageURL, String sliderLink, boolean sliderStatus, int priorities) {
		super();
		this.sliderId = sliderId;
		this.imageURL = imageURL;
		this.sliderLink = sliderLink;
		this.sliderStatus = sliderStatus;
		this.priorities = priorities;
	}
	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
