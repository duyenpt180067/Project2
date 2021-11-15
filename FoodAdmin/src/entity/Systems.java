package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "systems")
public class Systems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="system_id")
	private int systemId; 
	@Column(name="system_name")
	private String systemName;
	@Column(name="system_value")
	private String systemValue;
	public int getSystemId() {
		return systemId;
	}
	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSystemValue() {
		return systemValue;
	}
	public void setSystemValue(String systemValue) {
		this.systemValue = systemValue;
	}
	public Systems(int systemId, String systemName, String systemValue) {
		super();
		this.systemId = systemId;
		this.systemName = systemName;
		this.systemValue = systemValue;
	}
	public Systems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
