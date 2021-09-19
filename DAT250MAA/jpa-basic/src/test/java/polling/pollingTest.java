package polling;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class pollingTest {

    private static final String PERSISTENCE_UNIT_NAME = "polling";
    private EntityManagerFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select m from User2 m");
        // Persons should be empty

        // do we have entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
        if (createNewEntries) {
            Assert.assertTrue(q.getResultList().size() == 0);

            Poll poll = new Poll();
            poll.setPoll_name("Is hotdog a sandwitch?");
            poll.setAnswer1("Yes");
            poll.setAnswer2("No");
            em.persist(poll);

            User2 user2 = new User2();
            user2.setUser_name("xxxLmao42096xxx");
            em.persist(user2);

            ArrayList<User2> super_user2s = new ArrayList<>();
            super_user2s.add(user2);
            poll.setSuper_users(super_user2s);
            em.persist(poll);

            Answer answer = new Answer();
            answer.setAnswer("Yes");
            answer.setPoll(poll);
            answer.setUser2(user2);
            em.persist(answer);
        }

        // Commit the transaction, which will cause the entity to
        // be stored in the database
        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that
        // resources are conserved.
        em.close();

    }

    @Test
    public void checkPerson() {

        // now lets check the database and see if the created entries are there
        // create a fresh, new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all the Message entities
        Query q = em.createQuery("select u from Poll u");

        // We should have 1 Person in the database
        Assert.assertTrue(q.getResultList().size() == 1);

        em.close();
    }
}