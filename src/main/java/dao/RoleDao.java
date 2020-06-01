/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.UserDao.emf;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Role;

/**
 *
 * @author glamb
 */
public class RoleDao {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaUserTest");

    public List<Role> fetchAllRoles() {
        List<Role> roles = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        roles = em.createQuery("SELECT r from Role r").getResultList(); // Role k oxi Roles gt paei me to entity k oxi me th vash, edw einai JPQL

        em.close();
        return roles;
    }
}
