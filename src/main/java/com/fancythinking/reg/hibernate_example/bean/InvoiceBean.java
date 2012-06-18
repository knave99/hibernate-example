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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Query;

import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

@Entity
@Table	(name="tbl_invoice")
public class InvoiceBean {	

	Logger logger = Logger.getLogger(InvoiceBean.class);
	
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
		HibernateUtil.beginTransaction();
		Query query = session.createQuery("SELECT id FROM InvoiceBean WHERE invoicedDate = :date");
		query.setDate("date", date);
		list = (List<String>) query.list();
		HibernateUtil.commitTransaction();
		return list;
	}
	
	@Transient
	public synchronized String getNextQueryId(Long clientId) {
		Calendar cal = Calendar.getInstance();
		
		List<String> l = getInvoiceList(new Date());
		
		if ( l != null && l.size() > 0 ) {
			logger.debug("List size is " + l.size());
			logger.debug("Invoice Id List");
			for ( String s : l ) {
				logger.debug(s);
			}
		} else {
			logger.debug("Invoice list for day is null!");
		}
		 
		int i = l.size() + 1;
		String s = String.format("%03d", i);
		
		StringBuilder str = new StringBuilder();
		//date
		str.append(cal.get(Calendar.YEAR)+"-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
		//next invoice number
		str.append("/" + s + "-" + clientId);
		
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
	@Temporal	(value = TemporalType.DATE)
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
	@JoinColumn	(name="binary_id")
	public BinaryFile getFile() {
		return file;
	}
	public void setFile(BinaryFile file) {
		this.file = file;
	}
	
	public String toString() {
		return "InvoiceBean: ID:>" + getId() + "<" + " Amount:"+getAmount()+ " CustomerId:"+getCustomerId(); 
	}
	
	
}
