package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
import utils.JpaUtil;




public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		EventoDAO sd = new EventoDAO(em);
		
		Evento cena = new Evento("Cena", LocalDate.now(), "Cena di beneficenza", TipoEvento.PRIVATO, 30);
		sd.save(cena);
	}

}
