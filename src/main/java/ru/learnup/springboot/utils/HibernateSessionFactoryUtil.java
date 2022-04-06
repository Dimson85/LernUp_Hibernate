package ru.learnup.springboot.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.learnup.springboot.entity.Premiere;
import ru.learnup.springboot.entity.Ticket;


public class HibernateSessionFactoryUtil {
    public static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Premiere.class);
            configuration.addAnnotatedClass(Ticket.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (Exception e){
                System.out.println("Ошибка " + e);
            }
    }
        return sessionFactory;
    }
}
