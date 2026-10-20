package com.xworkz.common.repository.impl;

import com.xworkz.common.entity.UserEntity;
import com.xworkz.common.repository.UserRepo;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserRepoImpl implements UserRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public boolean saveUser(UserEntity user) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return  false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("email", email);
            UserEntity user = (UserEntity) query.getSingleResult();
            return user;

        } catch (NoResultException e) {
            System.out.println("Email does not exist");
            return null;

        } finally {
            entityManager.close();
        }
    }

    @Override
    public UserEntity findByPhoneNumber(Long phone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            Query query= entityManager.createNamedQuery("findByPhNo");
            query.setParameter("phone",phone);
            UserEntity user = (UserEntity) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.out.println("Phone Number does Not exist");
            e.printStackTrace();
        }finally{
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(userEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
         if(entityManager.getTransaction().isActive()){
             entityManager.getTransaction().rollback();
         }
         e.printStackTrace();
         return true;
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public UserEntity findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            return entityManager.find(UserEntity.class,id);
        }finally {
            entityManager.close();
        }
    }
}
