package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblUser.
 * @see com.cloudshaped.generated.TblUser
 * @author Hibernate Tools
 */
@Stateless
public class TblUserHome {

	private static final Log log = LogFactory.getLog(TblUserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblUser transientInstance) {
		log.debug("persisting TblUser instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblUser persistentInstance) {
		log.debug("removing TblUser instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblUser merge(TblUser detachedInstance) {
		log.debug("merging TblUser instance");
		try {
			TblUser result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblUser findById(long id) {
		log.debug("getting TblUser instance with id: " + id);
		try {
			TblUser instance = entityManager.find(TblUser.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
