package com.xworkz.common.repository.impl;

import com.xworkz.common.entity.LoginEntity;
import com.xworkz.common.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class LoginRepoImpl implements LoginRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public boolean saveLogin(LoginEntity loginEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(loginEntity);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
