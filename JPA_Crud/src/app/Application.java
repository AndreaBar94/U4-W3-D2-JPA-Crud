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
		
		Evento cena1 = new Evento("Cena", LocalDate.now(), "Cena di beneficenza", TipoEvento.PRIVATO, 30);
		Evento cena2 = new Evento("Cena 2", LocalDate.now(), "Cena di beneficenza", TipoEvento.PRIVATO, 30);
		Evento cena3 = new Evento("Cena 3", LocalDate.now(), "Cena di beneficenza", TipoEvento.PUBBLICO, 100);
		Evento cena4 = new Evento("Cena 4", LocalDate.now(), "Cena di beneficenza", TipoEvento.PUBBLICO, 200);
		//sd.save(cena1);
		//sd.save(cena2);
		//sd.save(cena3);
		//sd.save(cena4);
		//sd.delete(2);
		sd.refresh(4);
		logger.info("Evento: " + sd.findById(4).toString());
		em.close();

		emf.close();
	}

}
