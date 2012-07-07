package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * TblCarBeanOwner generated by hbm2java
 */
@Entity
@Table(name = "tbl_car_bean_owner", schema = "public")
public class TblCarBeanOwner implements java.io.Serializable {

	private long carBeanFk;
	private TblCarBean tblCarBean;
	private String owner;

	public TblCarBeanOwner() {
	}

	public TblCarBeanOwner(TblCarBean tblCarBean) {
		this.tblCarBean = tblCarBean;
	}

	public TblCarBeanOwner(TblCarBean tblCarBean, String owner) {
		this.tblCarBean = tblCarBean;
		this.owner = owner;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "tblCarBean"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "car_bean_fk", unique = true, nullable = false)
	public long getCarBeanFk() {
		return this.carBeanFk;
	}

	public void setCarBeanFk(long carBeanFk) {
		this.carBeanFk = carBeanFk;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public TblCarBean getTblCarBean() {
		return this.tblCarBean;
	}

	public void setTblCarBean(TblCarBean tblCarBean) {
		this.tblCarBean = tblCarBean;
	}

	@Column(name = "owner")
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}