package com.fancythinking.reg.hibernate_example.bean;

import java.util.Date;
import java.util.List;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.BinaryFileDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;
import com.fancythinking.reg.hibernate_example.dal.InvoiceBeanDAO;

public class InvoiceBeanTest extends SuperTest<InvoiceBean> {

	public InvoiceBeanTest(String testName) {
		super(testName);
	}
	
	@Override
	public void setUp() {
		dao = new InvoiceBeanDAO();
	}

	public BinaryFile createBinaryFile(String fileName, String fileType) {
		BinaryFile fileObject = new BinaryFile();
		fileObject.setName(fileName);
		fileObject.setPath("C:/work");
		fileObject.setType(fileType);
		byte[] array = BinaryFileUtil.read(fileObject.getFullPath()); 
		fileObject.setBytes(array);

		return fileObject;
	}
	
	public InvoiceBean createInvoice() {
		InvoiceBean ib = new InvoiceBean();
		ib.setAmount(5000.00);
		ib.setCustomerId(54L);
		ib.setInvoicedDate(new Date());
		ib.setFile(createBinaryFile("README", "txt"));
		ib.setId(ib.getNextQueryId(ib.getCustomerId()));
		create(ib);
		
		
		return ib;
	}
	
	
	public void testQuery() {
		InvoiceBean ib = new InvoiceBean();
		ib.setCustomerId(123456L);
		ib.setInvoicedDate(new Date());
		logger.debug(">>>" + ib.getNextQueryId(ib.getCustomerId()));
	}
	
	@Override
	public void testCreate() {
		//assertTrue(false);
		InvoiceBean ib = createInvoice();
		
		String id = ib.getId();
		ib = null;
		
		HibernateUtil.beginTransaction();
		InvoiceBean ibExample = new InvoiceBean();
		ibExample.setId(id);
		List<InvoiceBean> l = dao.findByExample(ibExample, false);
		
		assertTrue(l.size() > 0);
		HibernateUtil.commitTransaction();

	}

	@Override
	public void testUpdate() {
		InvoiceBean ib = createInvoice();
		String id = ib.getId();
		logger.debug(">>>1ID is " + id );
		HibernateUtil.beginTransaction();
		ib.setAmount(1000D);
		ib.setFile(null);
		dao.save(ib);
		logger.debug(">>>2ID is " + id);
		logger.debug("Value is " + ib.getAmount());
		HibernateUtil.beginTransaction();

		ib = dao.findByPrimaryKey(InvoiceBean.class, id);		
		logger.debug(ib);
		assertTrue(1000D == ib.getAmount());
	}

	@Override
	public void testDestroy() {
		InvoiceBean ib = createInvoice();
		String id = ib.getId();
		BinaryFile bf = ib.getFile();
		Long bfId = bf.getId();
		HibernateUtil.beginTransaction();				
		dao.delete(ib);
		ib = dao.findByPrimaryKey(InvoiceBean.class, id);
		BinaryFileDAO bfDAO = new BinaryFileDAO();
		bf = bfDAO.findByPrimaryKey(bfId);
		HibernateUtil.commitTransaction();
		assertTrue(ib == null);
		assertTrue(bf == null); 
	}

}
