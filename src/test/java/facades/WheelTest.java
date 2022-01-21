/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Company;
import entities.Field;
import entities.Player;
import entities.Spin;
import entities.Wheel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Tweny
 */
public class WheelTest {

    private static EntityManagerFactory emf;
    private static WheelFacade FACADE;
    private final Field f1 = new Field("Car", 200);
    private final Field f2 = new Field("Boat", 400);
    private final Field f3 = new Field("Jepp", 600);
    private final Field f4 = new Field("Chopper", 800);
    private final Field f5 = new Field("Bike", 1000);
    private final Wheel w = new Wheel("Wheel_test_name");
    private final Company c = new Company("test_company");
    private final Player p = new Player("test_player", "test@test.dk");

    public WheelTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        FACADE = WheelFacade.getFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Spin.deleteAllRows").executeUpdate();
            em.createNamedQuery("Field.deleteAllRows").executeUpdate();
            em.createNamedQuery("Wheel.deleteAllRows").executeUpdate();
            em.createNamedQuery("Company.deleteAllRows").executeUpdate();
            em.createNamedQuery("Player.deleteAllRows").executeUpdate();

            w.addField(f1);
            w.addField(f2);
            w.addField(f3);
            w.addField(f4);
            w.addField(f5);
            em.persist(w);

            c.addWheel(w);
            em.persist(c);

            em.persist(w);
            em.persist(p);

            Spin s = new Spin(w.getFields().size());
            s.setResultName(w.getFields());
            s.setResultValue(w.getFields());
            s.setPlayer(p);
            s.setWheel(w);
            em.persist(s);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void test_US1() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Spin s = new Spin(w.getFields().size());
            s.setResultName(w.getFields());
            s.setResultValue(w.getFields());
            s.setPlayer(p);
            s.setWheel(w);
            em.persist(s);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        assertEquals(2, FACADE.getAllSpins().size(), "Expects one rows in the database");
    }

}
