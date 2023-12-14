package ru.sabitov.springboottest.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sabitov.springboottest.models.ApplicationFeature;
import ru.sabitov.springboottest.models.Feature;
import ru.sabitov.springboottest.models.FeatureEnum;

@Repository
public class TestRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void saveAppFeature(ApplicationFeature applicationFeature){
        entityManager.persist(applicationFeature);
    }

    @Transactional
    public void saveFeatureEnum(FeatureEnum applicationFeature){
        entityManager.persist(applicationFeature);
    }


    public Feature getById(Long featureId){
        return entityManager.createQuery("from Feature where id = :id", Feature.class).setParameter("id", featureId).getSingleResult();
    }
}
