package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblNamex.
 * @see com.cloudshaped.generated.TblNamex
 * @author Hibernate Tools
 */
@Stateless
public class TblNamexHome {

	private static final Log log = LogFactory.getLog(TblNamexHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblNamex transientInstance) {
		log.debug("persisting TblNamex instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblNamex persistentInstance) {
		log.debug("removing TblNamex instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblNamex merge(TblNamex detachedInstance) {
		log.debug("merging TblNamex instance");
		try {
			TblNamex result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblNamex findById(long id) {
		log.debug("getting TblNamex instance with id: " + id);
		try {
			TblNamex instance = entityManager.find(TblNamex.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
