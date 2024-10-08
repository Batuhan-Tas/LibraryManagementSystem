package com.library.LibraryManagementSystem.dao;

import com.library.LibraryManagementSystem.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private EntityManager entityManager;


    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> get() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u",User.class);
        return query.getResultList();
    }

    @Override
    public User getByName(String name) {
        return entityManager.find(User.class,name);
    }

    @Transactional //in case of a problem during SAVE
    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public User delete(String name) {
        User removedUser = getByName(name);
        entityManager.remove(removedUser);
        return removedUser;

    }
}
