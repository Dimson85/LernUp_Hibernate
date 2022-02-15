package ru.learnup.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;


//@Scope("prototype")
public class Premiere {
    private String title;
    private String description;
    private String ageLimit;
    private int numberOfSeats;
    private Set<Ticket> soldTickets;

    public Premiere(String title, String description, String ageLimit, int numberOfSeats) {
        this.title = title;
        this.description = description;
        this.ageLimit = ageLimit;
        this.numberOfSeats = numberOfSeats;
    }

    //    public Premiere(String title,String description,String ageLimit,int numberOfSeats) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите название премьеры:");
//        this.title = scanner.nextLine();
//        System.out.println("Введите описание: ");
//        this.description = scanner.nextLine();
//        System.out.println("Введите ограничение по возрасту:");
//        this.ageLimit = scanner.nextLine();
//        System.out.println("Введите количество мест:");
//        this.numberOfSeats = scanner.nextInt();
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

    @Override
    public String toString() {
        return "Премьера {" + title + '\'' +
                ", Описание: '" + description + '\'' +
                ", Возрастное ограничение: " + ageLimit +
                ", Количество мест: " + numberOfSeats +
                '}';
    }

    public Set<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Set<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
    }
}
