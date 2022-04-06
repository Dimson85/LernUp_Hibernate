package ru.learnup.springboot.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "premiere")
public class Premiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "age_limit")
    private String ageLimit;

    @Column(name = "number_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "premiere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList;

    public Premiere() {
    }

    public Premiere(String title, String description, String ageLimit, int numberOfSeats) {
        this.title = title;
        this.description = description;
        this.ageLimit = ageLimit;
        this.numberOfSeats = numberOfSeats;
        this.ticketList = new ArrayList<>();
    }



//        public void removeTicket(Ticket ticket) {
//        ticketList.remove(ticket);
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "Премьера {" + '\'' + title + '\'' +
                ", Описание: '" + description + '\'' +
                ", Возрастное ограничение: " + ageLimit +
                ", Количество мест: " + numberOfSeats +
                '}';
    }

}