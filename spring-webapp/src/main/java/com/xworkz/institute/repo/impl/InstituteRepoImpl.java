package com.xworkz.institute.repo.impl;

import com.xworkz.institute.entity.InstituteEntity;
import com.xworkz.institute.repo.InstituteRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class InstituteRepoImpl implements InstituteRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public void saveInstitute(InstituteEntity institute) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(institute);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<InstituteEntity> getAllInstitutes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select i from InstituteEntity i");
        List<InstituteEntity> instituteEntityList = query.getResultList();
        entityManager.close();

        if(instituteEntityList == null){
            System.out.println("there is no Data");
        }

return  instituteEntityList;
    }

    @Override
    public InstituteEntity getInstituteById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select institute from InstituteEntity institute where id=:id");
        query.setParameter("id",id);
        InstituteEntity instituteEntity = (InstituteEntity) query.getSingleResult();
        entityManager.close();
        return instituteEntity;
    }

    @Override
    public void updateInstitute(InstituteEntity institute) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(institute);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public boolean deleteInstitute(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
         entityManager.createNamedQuery("deleteInstitute").setParameter("id", id).executeUpdate();
         entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
}