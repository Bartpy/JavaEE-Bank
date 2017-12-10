package pl.wipek.accounts.ejb.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.wipek.accounts.ejb.dao.AccountsDAO;
import pl.wipek.shared.domain.entity.Account;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AccountsDaoImplTest {

    protected static EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    @BeforeClass
    public static void createEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pl.wipek.database");
    }

    @Before
    public void beginTransaction() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void getUserAccounts() {
        Query query = entityManager
                .createQuery("FROM Account e WHERE e.customer.id=:id")
                .setParameter("id", "5a2c48b072938305fc481165");
//        Set<Account> result = accountsDAO.getUserAccounts("5a2c48b072938305fc481165");
        Set<Account> result = new HashSet<>(query.getResultList());
        System.out.println(result);
        Assert.assertNotEquals(0, result.size());
    }
}