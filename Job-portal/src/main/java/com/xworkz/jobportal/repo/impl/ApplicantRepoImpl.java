package com.xworkz.jobportal.repo.impl;

import com.xworkz.jobportal.entity.ApplicantEntity;
import com.xworkz.jobportal.repo.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ApplicantRepoImpl implements ApplicantRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveApplicant(ApplicantEntity applicantEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(applicantEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }


    @Override
    public List<ApplicantEntity> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager
                    .createQuery("select a from ApplicantEntity a", ApplicantEntity.class)
                    .getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public ApplicantEntity getApplicantById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(ApplicantEntity.class, id);
        } finally {
            entityManager.close();
        }
    }
}
