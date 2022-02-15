package ru.learnup.springboot.service;

import org.springframework.stereotype.Service;
import ru.learnup.springboot.Premiere;
import ru.learnup.springboot.Ticket;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {
    private Map<String, Premiere> listPremieres = new HashMap<>();


    public void addPremiere(String title, String description, String ageLimit, int numberOfSeats) {
        Premiere premiere = new Premiere(title, description, ageLimit, numberOfSeats);
        listPremieres.put(premiere.getTitle(), premiere);
        System.out.println("Премьера \"" + premiere.getTitle() + "\" успешно добавлена!");
    }


    public void removePremiere(String titlePremiere) {
        if (listPremieres.containsKey(titlePremiere)) {
            listPremieres.remove(titlePremiere);
            System.out.println("\nПремьера \"" + titlePremiere + "\" удалена\n");
        } else {
            System.out.println("Премьера с названием: \"" + titlePremiere+  "\" не найдена!\n");
        }
    }

        public void seeAllPremiere () {
            System.out.println("Доступные премьеры: " + listPremieres.keySet());
        }


        public void viewPremiere (String titlePremiere) {
            if (listPremieres.containsKey(titlePremiere)) {
                System.out.println(listPremieres.get(titlePremiere));
            } else {
                System.out.println("Премьера с названием: \"" + titlePremiere+  "\" не найдена!\n");
            }
        }

        public void buyTicket (String titlePremiere){
            Premiere premiere = null;
            if (listPremieres.containsKey(titlePremiere)) {
                premiere = listPremieres.get(titlePremiere);
                if (premiere.getNumberOfSeats() == 0) {
                    throw new IllegalArgumentException("Билеты на эту Премьеру закончились!");
                } else {
                    premiere.setNumberOfSeats(premiere.getNumberOfSeats() - 1);
                    Ticket ticket = new Ticket();
                    ticket.setTitlePremiere(premiere.getTitle());
                    premiere.getSoldTickets().add(ticket);
                    System.out.println("Билет куплен. Осталось билетов: " + premiere.getNumberOfSeats());
                }
            } else {
                System.out.println("Премьера с названием: \"" + titlePremiere+  "\" не найдена!\n");
            }
        }


        public void returnTicket (String titlePremiere, String buyersName){
            Premiere premiere = null;
            if (listPremieres.containsKey(titlePremiere)) {
                premiere = listPremieres.get(titlePremiere);
                for (Ticket ticket : premiere.getSoldTickets()) {
                    if (ticket.getBuyersName().equals(buyersName)) {
                        premiere.getSoldTickets().removeIf(ticketNm -> ticketNm.getBuyersName().contains(buyersName));
                        return;
                    }
                }
            } else {
                throw new IllegalArgumentException("Билет с  Фамилией покупателя \"" + buyersName + "\" не найден.");
            }
        }
    }
