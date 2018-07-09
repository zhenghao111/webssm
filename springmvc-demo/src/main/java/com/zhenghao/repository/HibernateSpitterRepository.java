package com.zhenghao.repository;


import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zhenghao.domain.Spitter;

import javax.inject.Inject;

//@Repository
public class HibernateSpitterRepository implements SpitterRepository{

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public Spitter findOne(String username) {
        return (Spitter) currentSession().get(Spitter.class, username);
    }

    @Override
    public Spitter findByUsername(String username) {
        throw new NotImplementedException();
    }


    @Override
    public void addSpitterWithNamedParam(Spitter spitter) {
        throw new NotImplementedException();
    }

    @Override
    public Spitter save(Spitter spitter) {
        throw new NotImplementedException();
    }




}
