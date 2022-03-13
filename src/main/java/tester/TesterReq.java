/**
 * @author Arik Gaarde Nielsen Twena
 */
package tester;

import entities.Category;
import entities.Category_level0;
import entities.Project;
import entities.Requirement;
import entities.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import utils.EMF_Creator;

public class TesterReq {

  public static void main(String[] args) {
    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    User u = em.find(User.class, 1);

    Category_level0 c = em.find(Category_level0.class, 1);

    Requirement r = new Requirement("Test description");
    r.setCategory_level0(c);
    r.setAuthor(u);
    em.persist(r);
    em.getTransaction().commit();

    em.getTransaction().begin();
    Requirement r1 = new Requirement("Test dependend");
    r.setCategory_level0(c);
    r1.setAuthor(u);
    r1.setDepended_on_id(r.getId());
    em.persist(r1);




    em.getTransaction().commit();
//    System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
  }

}
