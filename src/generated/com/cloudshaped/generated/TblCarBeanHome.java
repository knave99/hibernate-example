package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblCarBean.
 * @see com.cloudshaped.generated.TblCarBean
 * @author Hibernate Tools
 */
@Stateless
public class TblCarBeanHome {

	private static final Log log = LogFactory.getLog(TblCarBeanHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblCarBean transientInstance) {
		log.debug("persisting TblCarBean instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblCarBean persistentInstance) {
		log.debug("removing TblCarBean instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblCarBean merge(TblCarBean detachedInstance) {
		log.debug("merging TblCarBean instance");
		try {
			TblCarBean result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblCarBean findById(long id) {
		log.debug("getting TblCarBean instance with id: " + id);
		try {
			TblCarBean instance = entityManager.find(TblCarBean.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
