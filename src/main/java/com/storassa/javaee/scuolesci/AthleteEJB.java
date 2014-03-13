package main.java.com.storassa.javaee.scuolesci;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AthleteEJB {
	
	@PersistenceContext(unitName="scuoleSciPU")
	private EntityManager em;
	
	public List<Athlete> findAthlete() {
		Query query = em.createNamedQuery("findAllAthletes");
		return query.getResultList();
	}
	
	public Athlete createAthlete(Athlete athlete) {
		em.persist(athlete);
		return athlete;
	}
}
