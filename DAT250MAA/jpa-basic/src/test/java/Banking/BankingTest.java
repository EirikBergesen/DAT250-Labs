package Banking;

import Banking.Person;
import Banking.Bank;
import Banking.CreditCard;
import Banking.Pincode;
import Banking.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;


public class BankingTest {

    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private EntityManagerFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select m from Person m");
        // Persons should be empty

        // do we have entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
        if (createNewEntries) {
            Assert.assertTrue(q.getResultList().size() == 0);

            Address address = new Address();
            address.setNumber(28);
            address.setStreet("Inndalsveien");

            Person person = new Person();
            person.setName("Max Mustermann");

            CreditCard creditCard1 = new CreditCard();
            creditCard1.setNumber(12345);
            creditCard1.setBalance(-5000);
            creditCard1.setLimit(-10000);

            CreditCard creditCard2 = new CreditCard();
            creditCard2.setNumber(123);
            creditCard2.setBalance(1);
            creditCard2.setLimit(2000);

            Pincode pincode = new Pincode();
            pincode.setPincode("123");
            pincode.setCount(1);

            Bank bank = new Bank();
            bank.setName("Pengebank");

            // now persists the relationships
            ArrayList<Person> residents = new ArrayList<>();
            residents.add(person);
            address.setPersons(residents);
            em.persist(address);

            ArrayList<Address> addresses = new ArrayList<>();
            addresses.add(address);
            person.setAddresses(addresses);
            ArrayList<CreditCard> creditCards = new ArrayList<>();
            creditCards.add(creditCard1);
            creditCards.add(creditCard2);
            person.setCreditCards(creditCards);
            em.persist(person);

            creditCard1.setBank(bank);
            creditCard1.setPincode(pincode);
            em.persist(creditCard1);

            creditCard2.setBank(bank);
            creditCard2.setPincode(pincode);
            em.persist(creditCard2);

            bank.setCreditCards(creditCards);
            em.persist(bank);

            em.persist(pincode);
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
        Query q = em.createQuery("select p from Person p");

        // We should have 1 Person in the database
        Assert.assertTrue(q.getResultList().size() == 1);

        em.close();
    }

    @Test
    public void checkAddress() {
        EntityManager em = factory.createEntityManager();
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        Query q = em.createQuery("select a from Address a");

        // We should have one address with 1 person
        Assert.assertTrue(q.getResultList().size() == 1);
        Assert.assertTrue(((Address) q.getSingleResult()).getPersons().size() == 1);
        em.close();
    }
}