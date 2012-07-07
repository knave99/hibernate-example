package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblCarBeanModel.
 * @see com.cloudshaped.generated.TblCarBeanModel
 * @author Hibernate Tools
 */
@Stateless
public class TblCarBeanModelHome {

	private static final Log log = LogFactory.getLog(TblCarBeanModelHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblCarBeanModel transientInstance) {
		log.debug("persisting TblCarBeanModel instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblCarBeanModel persistentInstance) {
		log.debug("removing TblCarBeanModel instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblCarBeanModel merge(TblCarBeanModel detachedInstance) {
		log.debug("merging TblCarBeanModel instance");
		try {
			TblCarBeanModel result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblCarBeanModel findById(long id) {
		log.debug("getting TblCarBeanModel instance with id: " + id);
		try {
			TblCarBeanModel instance = entityManager.find(
					TblCarBeanModel.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
