package br.com.igrejavpc.util.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequestScoped
public class EntityManagerProducer {
	
	@PersistenceContext(unitName = "IgrejaDS")			
	private EntityManager em;

	@Produces
	@RequestScoped
	public EntityManager create() {
		return this.em;
	}

	
	
}
