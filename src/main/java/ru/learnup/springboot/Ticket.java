package ru.learnup.springboot;
import org.springframework.stereotype.Component;

import java.util.Scanner;


public class Ticket {
    String buyersName;
    String titlePremiere;

    public Ticket() {
        System.out.println("Введите Фамилию покупателя: ");
        this.buyersName = new Scanner(System.in).nextLine();
    }



    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "buyersName='" + buyersName + '\'' +
                ", titlePremiere='" + titlePremiere + '\'' +
                '}';
    }

    public String getTitlePremiere() {
        return titlePremiere;
    }

    public void setTitlePremiere(String titlePremiere) {
        this.titlePremiere = titlePremiere;
    }
}
