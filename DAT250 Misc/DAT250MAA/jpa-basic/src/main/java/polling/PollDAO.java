package polling;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class PollDAO {
    private static final String PERSISTENCE_UNIT_NAME = "polling";
    private EntityManagerFactory factory;

    public PollDAO() {

    }


    public void persistPoll(Poll poll) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
        em.close();
    }
}
