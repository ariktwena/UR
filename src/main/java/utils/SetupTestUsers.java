package utils;

import entities.Department;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public void setupUsers() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

//     IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//     This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
//     CHANGE the three passwords below, before you uncomment and execute the code below
//     Also, either delete this file, when users are created or rename and add to .gitignore
//     Whatever you do DO NOT COMMIT and PUSH with the real passwords
        Department d1 = new Department("PMO");
        Department d2 = new Department("Finance");
        Department d3 = new Department("R&D");

        User user = new User("User first name", "User last name", "user", "1234");
        User admin = new User("Admin first name", "Admin last name", "admin", "1234");
        User both = new User("Arik", "Gaarde Nielsen", "arik", "1234");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

        em.getTransaction().begin();

        d1.addUser(both);
        d2.addUser(admin);
        d3.addUser(user);
        em.persist(d1);
        em.persist(d2);
        em.persist(d3);

        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);

        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));

        em.getTransaction().commit();
        System.out.println("Created TEST Users");
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

//     IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//     This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
//     CHANGE the three passwords below, before you uncomment and execute the code below
//     Also, either delete this file, when users are created or rename and add to .gitignore
//     Whatever you do DO NOT COMMIT and PUSH with the real passwords
        Department d1 = new Department("PMO");
        Department d2 = new Department("Finance");
        Department d3 = new Department("R&D");

        User user = new User("User first name", "User last name", "user", "1234");
        User admin = new User("Admin first name", "Admin last name", "admin", "1234");
        User both = new User("Arik", "Gaarde Nielsen", "arik", "1234");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

        em.getTransaction().begin();

        d1.addUser(both);
        d2.addUser(admin);
        d3.addUser(user);
        em.persist(d1);
        em.persist(d2);
        em.persist(d3);

        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);

        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));

        em.getTransaction().commit();
        System.out.println("Created TEST Users");

    }

}
