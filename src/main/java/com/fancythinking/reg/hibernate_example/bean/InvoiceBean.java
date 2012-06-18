package com.fancythinking.reg.hibernate_example.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table	(name="tbl_invoice")
public class InvoiceBean {

	private String id;
	private Double amount;
	private Date invoicedDate;
	private Long customerId;
	private BinaryFile file;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getInvoicedDate() {
		return invoicedDate;
	}
	public void setInvoicedDate(Date invoicedDate) {
		this.invoicedDate = invoicedDate;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@OneToOne (
			fetch=FetchType.LAZY					
	)
	@JoinColumn	(name="invoice_id")
	public BinaryFile getFile() {
		return file;
	}
	public void setFile(BinaryFile file) {
		this.file = file;
	}
	
	
}
