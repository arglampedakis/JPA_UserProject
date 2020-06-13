/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.OurFile;

/**
 *
 * @author glamb
 */
public class FileDao {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaUserTest");

    public void insertFile(OurFile f) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public OurFile getFileById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(OurFile.class, id);
    }
}
