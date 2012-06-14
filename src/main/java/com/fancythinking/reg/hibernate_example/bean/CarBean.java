package com.fancythinking.reg.hibernate_example.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table (name="tbl_car_bean")
@SecondaryTables ( {
	@SecondaryTable (	name="tbl_car_bean_model",
						pkJoinColumns=@PrimaryKeyJoinColumn(name="car_bean_fk")
	),
	@SecondaryTable (	name="tbl_car_bean_owner",
						pkJoinColumns=@PrimaryKeyJoinColumn(name="car_bean_fk")
	)
})
public class CarBean {
	private Long id;
	private Date modelYear;
	private String modelName;
	private String owner;
	private List<NameX> waitingList;
	
	
	public CarBean() {}
	
	public CarBean(Date modelYear, String modelName, String owner) {
		this.modelYear = modelYear;
		this.modelName = modelName;
	}
	
	@Id
	@GeneratedValue 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column (table="tbl_car_bean_model")
	@Temporal (value=TemporalType.DATE)
	public Date getModelYear() {
		return modelYear;
	}
	public void setModelYear(Date modelYear) {
		this.modelYear = modelYear;
	}
	@Column (table="tbl_car_bean_model")
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@OneToMany (mappedBy="id")
	public List<NameX> getWaitingList() {
		return waitingList;
	}
	public void setWaitingList(List<NameX> waitingList) {
		this.waitingList = waitingList;
	}
	
	@Column (table="tbl_car_bean_owner")
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID:" + getId() + " Model: " + getModelName() + ":" + getModelYear() + " owned by " + getOwner() + "\nWaiting List\n");
		if ( waitingList != null ) {
			for ( NameX n : waitingList ) {
				sb.append(n.toString() +"\n");
			}
		} else {
			sb.append( "empty\n" );
		}
		return sb.toString();    
	}
}
