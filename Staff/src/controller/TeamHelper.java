package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Staff");

	public List<Team> getTeamList() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> query = em.createQuery("select t from Team t", Team.class);
		List<Team> foundTeams = query.getResultList();
		em.close();
		return foundTeams;
	}

	public void addTeam(Team teamToAdd) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(teamToAdd);
		em.getTransaction().commit();
		em.close();
	}

	public Team findTeamById(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Team result = em.find(Team.class, id);
		em.close();
		return result;
	}

	public void deleteTeam(Team toDel) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> tq = em.createQuery("SELECT t FROM Team t where t.teamId = :id", Team.class);
		tq.setParameter("id", toDel.getTeamId());
		Team result = tq.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

}
