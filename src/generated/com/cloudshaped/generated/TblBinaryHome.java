package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblBinary.
 * @see com.cloudshaped.generated.TblBinary
 * @author Hibernate Tools
 */
@Stateless
public class TblBinaryHome {

	private static final Log log = LogFactory.getLog(TblBinaryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblBinary transientInstance) {
		log.debug("persisting TblBinary instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblBinary persistentInstance) {
		log.debug("removing TblBinary instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblBinary merge(TblBinary detachedInstance) {
		log.debug("merging TblBinary instance");
		try {
			TblBinary result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblBinary findById(long id) {
		log.debug("getting TblBinary instance with id: " + id);
		try {
			TblBinary instance = entityManager.find(TblBinary.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
