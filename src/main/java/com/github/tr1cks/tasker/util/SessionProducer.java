package com.github.tr1cks.tasker.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@ApplicationScoped
public class SessionProducer {

    @Produces @Named("sessionFactory") @ApplicationScoped
    public SessionFactory createSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
