package ru.learnup.springboot.service;


import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.learnup.springboot.dao.TicketDao;
import ru.learnup.springboot.entity.Premiere;
import ru.learnup.springboot.dao.PremiereDao;
import ru.learnup.springboot.entity.Ticket;
import ru.learnup.springboot.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class EventService {

    final PremiereDao premiereDao;

    final TicketDao ticketDao;

    public EventService(PremiereDao premiereDao, TicketDao ticketDao) {
        this.premiereDao = premiereDao;
        this.ticketDao = ticketDao;
    }


    public void printAllPremiere() {
        for (Premiere premiere : premiereDao.getAllPremiere()) {
            System.out.println(premiere);
        }
    }

    public Premiere findByTitle(String title) {
        Premiere premiere = null;
        List<Premiere> premiereList = premiereDao.findPremiereByTitle(title);
        if (!premiereList.isEmpty()) {
            for (Premiere pre : premiereList) {
                premiere = pre;
            }
        } else {
            throw new IllegalArgumentException("Премьера с именем " + title + " не найдена.");
        }
        return premiere;
    }

//    public List<Premiere> findByTitle(String title) {
//        return premiereDao.findPremiereByTitle(title);
//    }

    public void addPremiere(Premiere premiere) {
        premiereDao.addPremiere(premiere);
    }

    public void removePremiere(String title){
        Premiere premiere = this.findByTitle(title);
        premiereDao.deletePremiere(premiere);
    }


    public void buyTicket(String title, String buyerName) {
        Premiere premiere = this.findByTitle(title);
        Ticket ticket = new Ticket(premiere, buyerName);
        ticket.setPremiere(premiere);
        premiere.getTicketList().add(ticket);
        premiereDao.buyTickets(premiere);
    }

    public void deleteTicketByBuyerName(String title, String buyerName) {
        List<Ticket> ticketList = ticketDao.findTicketByBuyersName(buyerName);
        if (!ticketList.isEmpty()) {
            for (Ticket ticket : ticketList) {
                if (ticket.getBuyersName().equalsIgnoreCase(buyerName)
                        && ticket.getTitlePremiere().equalsIgnoreCase(title)) {
                    ticketDao.deleteTicket(ticket);
                }
            }
        } else {
            throw new IllegalArgumentException("Покупатель " + buyerName + " на премьеру " + title + " не найден.");
        }
    }
}



