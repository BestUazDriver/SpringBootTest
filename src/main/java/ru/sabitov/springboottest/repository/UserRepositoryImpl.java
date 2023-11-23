package ru.sabitov.springboottest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sabitov.springboottest.models.User;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers(){
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        Query query = entityManager.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
}
