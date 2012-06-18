package com.fancythinking.reg.hibernate_example.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Query;

import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

@Entity
@Table	(name="tbl_invoice")
public class InvoiceBean {

	private String id;
	private Double amount;
	private Date invoicedDate;
	private Long customerId;
	private BinaryFile file;
	
	@SuppressWarnings("unchecked")
	@Transient
	public List<String> getInvoiceList(Date date) {
		List<String> list = null;
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("SELECT id FROM InvoiceBean WHERE date = :date");
		query.setDate("date", date);
		list = (List<String>) query.list();
		HibernateUtil.commitTransaction();
		return list;
	}
	
	@Transient
	public String getNextQueryId(Long clientId) {
		Calendar cal = Calendar.getInstance();
		
		List<String> l = getInvoiceList(new Date());
		int i = l.size() + 1;
		
		StringBuilder str = new StringBuilder();
		//date
		str.append(cal.get(Calendar.YEAR)+"-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
		//next invoice number
		str.append("/" + i + "-" + clientId);
		
		return str.toString();
	}
	
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
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL
	)
	@JoinColumn	(name="invoice_id")
	public BinaryFile getFile() {
		return file;
	}
	public void setFile(BinaryFile file) {
		this.file = file;
	}
	
	
}
