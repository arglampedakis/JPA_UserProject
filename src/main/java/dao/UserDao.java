/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Role;
import model.User;

/**
 *
 * @author glamb
 */
public class UserDao {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaUserTest");

    public List<User> fetchAllUsers() {
        List<User> result = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        result = em.createQuery("SELECT u from User u").getResultList();

        em.close();
        return result;
    }

    public User getUserById(int userid) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, userid);
        em.close();
        return user;
    }

    public void deleteUser(int userid) {
        EntityManager em = emf.createEntityManager();
//        User user = getUserById(userid);
        User user = em.find(User.class, userid);
        em.getTransaction().begin(); //begin transaction (χρειαζεται επειδη κανω αλλαγη στη βαση)
        em.remove(user);
        em.flush();// του λεω οτι την απο πανω εντολη θελω να την κανεις τωρα
        em.getTransaction().commit();//τρεχω το transaction
        em.close();
    }

    public void updateUser(int id, String name) {
        EntityManager em = emf.createEntityManager();
        User user = getUserById(id);
        em.getTransaction().begin();
        user.setUsername(name);
        em.merge(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public boolean insertUser(String name, int roleid) {
        EntityManager em = emf.createEntityManager();
        Role role = em.find(Role.class, roleid);
        User newUser = new User();
        newUser.setUsername(name);
        newUser.setRoleId(role);

        em.getTransaction().begin();
        em.persist(newUser);
        em.flush();
        em.getTransaction().commit();

        return em.contains(newUser);
    }
}
