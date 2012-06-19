package com.fancythinking.reg.hibernate_example.bean;

import com.fancythinking.reg.hibernate_example.SuperTest;
import com.fancythinking.reg.hibernate_example.dal.DAOFactory;

public class BinaryFileTest extends SuperTest<BinaryFile, Long> {

	public BinaryFileTest(String testName) {
		super(testName);
	}
	

	@Override
	public void setUp() {
		dao = DAOFactory.getInstance().getBinaryFileDAO();
	}

	public BinaryFile createBinaryFile() {
		BinaryFile fileObject = new BinaryFile();

		//String fileName = "maven-complete-reference";
		fileObject.setName("GIT");
		fileObject.setPath("C:/work");
		fileObject.setType("pdf");
		byte[] array = BinaryFileUtil.read(fileObject.getFullPath()); 
		fileObject.setBytes(array);
		create(fileObject);

		return fileObject;
	}
	
	@Override
	public void testCreate() {
		BinaryFile f = createBinaryFile();
		Long id = f.getId();
		f = null;
		dao.beginTransaction();
		f = findBean(id);
		assertTrue(f.getId() != null);
		assertTrue(f.getBytes() != null);
		assertTrue(f.getBytes().length > 0);
		dao.commitTransaction();
		BinaryFileUtil.writeFile("c:/work/Git_out.pdf", f.getBytes());
	}

	@Override
	public void testUpdate() {
		BinaryFile f = createBinaryFile();
		
		dao.beginTransaction();				
		f.setName("README");
		f.setType("txt");
		f.setBytes(BinaryFileUtil.read(f.getFullPath()));
		dao.save(f);		
		dao.commitTransaction();
		Long id = f.getId();
		f = null;
		
		dao.beginTransaction();
		f = findBean(id);
		assertTrue("README".equals(f.getName()));
		BinaryFileUtil.writeFile("c:/work/read_out.txt", f.getBytes());
		dao.commitTransaction();		
	}

	@Override
	public void testDestroy() {
		BinaryFile f = createBinaryFile();
		dao.beginTransaction();		
		dao.delete(f);
		f = findBean(f.getId());
		dao.commitTransaction();
		assertTrue(f == null);

	}

}
