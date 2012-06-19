package com.fancythinking.reg.hibernate_example.dal;

public class DAOHibernateFactory extends DAOFactory {

	@Override
	public IBinaryFileDAO getBinaryFileDAO() {
		return new BinaryFileDAO();
	}

	@Override
	public ICarBeanDAO getCarBeanDAO() {
		return new CarBeanDAO();
	}

	@Override
	public ICourseDAO getCourseDAO() {
		return new CourseDAO();
	}

	@Override
	public IInvoiceBeanDAO getInvoiceBeanDAO() {
		return new InvoiceBeanDAO();
	}

	@Override
	public IUserBeanDAO getUserBeanDAO() {		
		return new UserBeanDAO();
	}

	@Override
	public INameXDAO getNameXDAO() {	
		return new NameXDAO();
	}
}
