package com.fancythinking.reg.hibernate_example.dal;

import com.fancythinking.reg.hibernate_example.bean.InvoiceBean;

public class InvoiceBeanDAO extends DAO<InvoiceBean, String> implements IInvoiceBeanDAO {

	public InvoiceBeanDAO() {
		super(InvoiceBean.class);
	}
}
