package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TblNamex generated by hbm2java
 */
@Entity
@Table(name = "tbl_namex", schema = "public")
public class TblNamex implements java.io.Serializable {

	private long id;
	private TblCarBean tblCarBean;
	private String firstname;
	private String surname;

	public TblNamex() {
	}

	public TblNamex(long id) {
		this.id = id;
	}

	public TblNamex(long id, TblCarBean tblCarBean, String firstname,
			String surname) {
		this.id = id;
		this.tblCarBean = tblCarBean;
		this.firstname = firstname;
		this.surname = surname;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	public TblCarBean getTblCarBean() {
		return this.tblCarBean;
	}

	public void setTblCarBean(TblCarBean tblCarBean) {
		this.tblCarBean = tblCarBean;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "surname")
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
