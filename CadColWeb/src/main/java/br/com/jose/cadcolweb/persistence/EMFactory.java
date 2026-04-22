package br.com.jose.cadcolweb.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFactory {

	private static EntityManager em;

	public static EntityManager getEm() {

		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadcolwebPU");
			em = factory.createEntityManager();
		}
		return em;
	}

}