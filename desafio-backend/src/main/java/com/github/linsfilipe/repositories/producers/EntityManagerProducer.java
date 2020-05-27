package com.github.linsfilipe.repositories.producers;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {
	
	private static final long serialVersionUID = 1908259755126360819L;
	
	@PersistenceUnit(unitName = "desafioDS")
    private EntityManagerFactory factory;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManager manager) {
        if (manager != null && manager.isOpen())
            manager.close();
    }

}
