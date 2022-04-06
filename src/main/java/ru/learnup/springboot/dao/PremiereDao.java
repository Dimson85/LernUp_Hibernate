package ru.learnup.springboot.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.learnup.springboot.entity.Premiere;
import ru.learnup.springboot.entity.Ticket;
import ru.learnup.springboot.utils.HibernateSessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;



@Component
public class PremiereDao {

    public List<Premiere> findPremiereByTitle(String title) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Premiere WHERE title = :paramName", Premiere.class);
            query.setParameter("paramName",title);
            Query query1 = session.createQuery("FROM Ticket WHERE titlePremiere = :paramTitle", Ticket.class);
            query1.setParameter("paramTitle",title);
            List<Premiere> premiereList= query.list();
            premiereList.forEach(p->p.setTicketList(query1.list()));
            return premiereList;
        }
    }

    public void addPremiere(Premiere premiere) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(premiere);
            transaction.commit();
        }
    }

    public void updatePremiere(Premiere premiere) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(premiere);
            transaction.commit();
        }
    }
        public void deletePremiere(Premiere premiere) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(premiere);
                transaction.commit();
            }
        }

        public void buyTickets(Premiere premiere){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(premiere);
                transaction.commit();
            }
        }




    public List<Premiere> getAllPremiere() {
        List<Premiere> allPremiere = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Query<Premiere> allQuery = session.createQuery("from Premiere", Premiere.class);
            return allQuery.getResultList();
        }
    }


}


