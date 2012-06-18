package com.fancythinking.reg.hibernate_example.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.xml.stream.util.StreamReaderDelegate;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.BinaryFileDAO;
import com.fancythinking.reg.hibernate_example.dal.HibernateUtil;

public class BinaryFileTest extends SuperTest<BinaryFile> {

	public BinaryFileTest(String testName) {
		super(testName);
	}

	@Override
	public void setUp() {
		dao = new BinaryFileDAO();
	}

	public BinaryFile createBinaryFile() {
		BinaryFile fileObject = new BinaryFile();

		String fileName = "AllVenoxis";
		String path = "F:/uploads/";
		String fileType = "jpg";
		byte[] array = BinaryFileUtil.read(path + fileName + "." + fileType); 
		fileObject.setBytes(array);
		fileObject.setFileName(fileName+"."+fileType);
		create(fileObject);

		return fileObject;
	}
	
	@Override
	public void testCreate() {
		BinaryFile f = createBinaryFile();
		Long id = f.getId();
		f = null;
		f = findBean(id);		
		assertTrue(f.getId() != null);
		assertTrue(f.getBytes() != null);
		assertTrue(f.getBytes().length > 0);
	}

	@Override
	public void testUpdate() {
		BinaryFile c1 = createBinaryFile();
		
		HibernateUtil.beginTransaction();
		Long id = c1.getId();
/*
		f.
		c1.getStudentList().get(0).setFirstName(first);
		dao.save(c1);
		c1 = null;
		c1 = dao.findByPrimaryKey(id);
		HibernateUtil.commitTransaction();

		assertTrue(chemistry.equals(c1.getName()));
		assertTrue(first.equals(c1.getStudentList().get(0).getFirstName()));
*/
		assertTrue(false);
	}

	@Override
	public void testDestroy() {
		/*
		BinaryFile c1 = createBinaryFile();
		HibernateUtil.beginTransaction();		
		dao.delete(c1);
		c1 = dao.findByPrimaryKey(c1.getBinaryFileId());
		HibernateUtil.commitTransaction();
		
		assertTrue(c1 == null);
		*/
		assertTrue(false);
	}

}
