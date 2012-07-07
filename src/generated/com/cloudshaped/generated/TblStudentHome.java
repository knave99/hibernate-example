package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblStudent.
 * @see com.cloudshaped.generated.TblStudent
 * @author Hibernate Tools
 */
@Stateless
public class TblStudentHome {

	private static final Log log = LogFactory.getLog(TblStudentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblStudent transientInstance) {
		log.debug("persisting TblStudent instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblStudent persistentInstance) {
		log.debug("removing TblStudent instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblStudent merge(TblStudent detachedInstance) {
		log.debug("merging TblStudent instance");
		try {
			TblStudent result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblStudent findById(long id) {
		log.debug("getting TblStudent instance with id: " + id);
		try {
			TblStudent instance = entityManager.find(TblStudent.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
