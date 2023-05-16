package dao;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;
import entities.TipoEvento;

public class EventoDAO {
	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Evento s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Evento salvato");
	}

	public Evento findById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		if(found != null) {
			found.setTitolo("Pranzo");
		found.setDataEvento(LocalDate.now());
		found.setDescrizione("Se magna");
		found.setNumeroMassimoPartecipanti(30);
		found.setTipoEvento(TipoEvento.PUBBLICO);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
		}else {
			System.out.println("Nessun evento trovato");
		}
		
	}
}
