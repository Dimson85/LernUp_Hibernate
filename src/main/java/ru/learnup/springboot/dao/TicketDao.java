package ru.learnup.springboot.dao;

import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.learnup.springboot.entity.Ticket;
import ru.learnup.springboot.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class TicketDao {
    public List<Ticket> findTicketByBuyersName(String buyersName) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Ticket WHERE buyersName = :paramName", Ticket.class);
            query.setParameter("paramName", buyersName);
            return query.list();
        }
    }

    public void deleteTicket(Ticket ticket) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

}
