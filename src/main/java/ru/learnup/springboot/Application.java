package ru.learnup.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.learnup.springboot.service.EventService;


public class Application {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EventService eventService = context.getBean(EventService.class);
        eventService.printAllPremiere();
//        EventService eventService = context.getBean(EventService.class);
//        eventService.removePremiere("Русалочка");
//        eventService.buyTicket("Русалочка","Костя");

//        System.out.println(eventService.findByTitle("Русалочка"));
//        Premiere premiere = new Premiere("Три медведя","Про медведей",
//                "0+",50);
//        eventService.addPremiere(premiere);


//        System.out.println(eventService.findByTitle("Русалочка"));
//        eventService.buyTicket(premiere,"Людмила");
//        Premiere premiere = new Premiere("Королева цирка","Про цирк",
//                "0+",50);
//        eventService.addPremiere(premiere);


        context.close();

    }
}
