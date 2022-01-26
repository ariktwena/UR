package tester;

import entities.Project;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import utils.EMF_Creator;

public class TesterPersist {

  public static void main(String[] args) {
    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    User u = em.find(User.class, 1);

    Project p = new Project("Test Project no given ");

//    u.addProject(p);
//    em.persist(u);

    Query query = em.createQuery("SELECT p FROM Project p WHERE p.projectName = :name ", Project.class);
    query.setParameter("name", p.getProjectName());
    p = (Project) query.getSingleResult();
    p.setUser(u);

    em.merge(p);


    em.getTransaction().commit();
  }

}
