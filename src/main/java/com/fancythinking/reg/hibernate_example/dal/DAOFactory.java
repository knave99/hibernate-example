package com.fancythinking.reg.hibernate_example.dal;


public abstract class DAOFactory {
	
	private final static Class<?> FACTORY_CLASS = DAOHibernateFactory.class;
			
	public static DAOFactory getInstance() {
		try {
			return (DAOFactory) FACTORY_CLASS.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("DAOFactory could not be created");
		}
	}
	


	
	public abstract IBinaryFileDAO getBinaryFileDAO();
	public abstract ICarBeanDAO getCarBeanDAO();
	public abstract ICourseDAO getCourseDAO();
	public abstract IInvoiceBeanDAO getInvoiceBeanDAO();
	public abstract IUserBeanDAO getUserBeanDAO();
	public abstract INameXDAO getNameXDAO();
	
}
