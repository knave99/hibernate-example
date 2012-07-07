package com.cloudshaped.generated;

// Generated 07-Jul-2012 08:44:37 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Userbean.
 * @see com.cloudshaped.generated.Userbean
 * @author Hibernate Tools
 */
@Stateless
public class UserbeanHome {

	private static final Log log = LogFactory.getLog(UserbeanHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userbean transientInstance) {
		log.debug("persisting Userbean instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userbean persistentInstance) {
		log.debug("removing Userbean instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userbean merge(Userbean detachedInstance) {
		log.debug("merging Userbean instance");
		try {
			Userbean result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userbean findById(long id) {
		log.debug("getting Userbean instance with id: " + id);
		try {
			Userbean instance = entityManager.find(Userbean.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
