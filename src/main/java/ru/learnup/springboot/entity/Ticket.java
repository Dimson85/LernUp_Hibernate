package ru.learnup.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="buyers_name")
    String buyersName;

    @Column(name = "title_premiere")
    String titlePremiere;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_premiere")
    private Premiere premiere;

    public Ticket() {
    }

    public Ticket(Premiere premiere,String buyersName) {
        this.titlePremiere = premiere.getTitle();
        this.buyersName = buyersName;
        this.premiere = premiere;
    }

    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    public String getTitlePremiere() {
        return titlePremiere;
    }

    public void setTitlePremiere(String titlePremiere) {
        this.titlePremiere = titlePremiere;
    }


    public Premiere getPremiere() {
        return premiere;
    }

    public void setPremiere(Premiere premiere) {
        this.premiere = premiere;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "buyersName='" + buyersName + '\'' +
                ", titlePremiere='" + titlePremiere + '\'' +
                '}';
    }
}
