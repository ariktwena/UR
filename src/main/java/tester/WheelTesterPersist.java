/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import dto.SpinDTO;
import entities.Company;
import entities.Field;
import entities.Player;
import entities.Spin;
import entities.Wheel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author Tweny
 */
public class WheelTesterPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Field f1 = new Field("Car", 200);
        Field f2 = new Field("Boat", 400);
        Field f3 = new Field("Jepp", 600);
        Field f4 = new Field("Chopper", 800);
        Field f5 = new Field("Bike", 1000);
        Wheel w = new Wheel("Wheel_test_name");
        w.addField(f1);
        w.addField(f2);
        w.addField(f3);
        w.addField(f4);
        w.addField(f5);
        em.persist(w);
        
        
        
        
        Company c = new Company("test_company");
        c.addWheel(w);
        em.persist(c);
        
        
        Player p = new Player("test_player", "test@test.dk");
        em.persist(w);
        em.persist(p);
        
        Spin s = new Spin(w.getFields().size());
//        SpinDTO sdto = new SpinDTO(s);
//        System.out.println(sdto);
        s.setResultName(w.getFields());
        s.setResultValue(w.getFields());
        s.setPlayer(p);
        s.setWheel(w);
        em.persist(s);
        
        em.getTransaction().commit();
    }
}
