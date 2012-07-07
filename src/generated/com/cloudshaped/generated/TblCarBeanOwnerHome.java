package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblCarBeanOwner.
 * @see com.cloudshaped.generated.TblCarBeanOwner
 * @author Hibernate Tools
 */
@Stateless
public class TblCarBeanOwnerHome {

	private static final Log log = LogFactory.getLog(TblCarBeanOwnerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblCarBeanOwner transientInstance) {
		log.debug("persisting TblCarBeanOwner instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblCarBeanOwner persistentInstance) {
		log.debug("removing TblCarBeanOwner instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblCarBeanOwner merge(TblCarBeanOwner detachedInstance) {
		log.debug("merging TblCarBeanOwner instance");
		try {
			TblCarBeanOwner result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblCarBeanOwner findById(long id) {
		log.debug("getting TblCarBeanOwner instance with id: " + id);
		try {
			TblCarBeanOwner instance = entityManager.find(
					TblCarBeanOwner.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
