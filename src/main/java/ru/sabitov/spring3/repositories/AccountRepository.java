package ru.sabitov.spring3.repositories;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sabitov.spring3.models.Account;
import ru.sabitov.spring3.models.Ill;

import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    private EntityManager entityManager;

    private Session session() {
        return entityManager.unwrap(Session.class);
    }

    public Account findByAccountId(Long accountId) {
        Query<Account> query = session().createQuery("from Account where id = :accountId", Account.class);
        query.setParameter("accountId", accountId);
        return (Account) query.getSingleResult();
    }

    public Account getByNativeId(Long id){
        Query query = session().createQuery("select id from Account where id = :id");
        query.setParameter("id", id);
        return (Account) query.getSingleResult();
    }

    @Transactional
    public void saveAcc(Account account){
        entityManager.unwrap(Session.class).persist(account);
    }

    @Transactional
    public void doSomeShitWithModels(Account byAccountId, List<Ill> illness) {
        session().save(byAccountId);
        byAccountId.setName("bratok");
        session().merge(byAccountId);
        byAccountId.setName("ne_bratok");
        session().merge(byAccountId);
    }
}
