package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TblCourse.
 * @see com.cloudshaped.generated.TblCourse
 * @author Hibernate Tools
 */
@Stateless
public class TblCourseHome {

	private static final Log log = LogFactory.getLog(TblCourseHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TblCourse transientInstance) {
		log.debug("persisting TblCourse instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TblCourse persistentInstance) {
		log.debug("removing TblCourse instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TblCourse merge(TblCourse detachedInstance) {
		log.debug("merging TblCourse instance");
		try {
			TblCourse result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblCourse findById(long id) {
		log.debug("getting TblCourse instance with id: " + id);
		try {
			TblCourse instance = entityManager.find(TblCourse.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
