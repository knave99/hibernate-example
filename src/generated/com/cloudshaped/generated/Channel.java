package com.cloudshaped.generated;

// Generated 08-Jul-2012 17:47:20 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Channel generated by hbm2java
 */
@Entity
@Table(name = "channel", schema = "public")
public class Channel implements java.io.Serializable {

	private long id;
	private Service service;
	private String name;
	private Boolean isFree;

	public Channel() {
	}

	public Channel(long id) {
		this.id = id;
	}

	public Channel(long id, Service service, String name, Boolean isFree) {
		this.id = id;
		this.service = service;
		this.name = name;
		this.isFree = isFree;
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
	@JoinColumn(name = "service")
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "\"isFree\"")
	public Boolean getIsFree() {
		return this.isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}

}