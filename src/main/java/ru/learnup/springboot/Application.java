package ru.learnup.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.learnup.springboot.service.EventService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        EventService eventService = context.getBean(EventService.class);
        eventService.addPremiere("Руслан и Людмила", "Про Руслана и Людмилу","3+", 32);
        eventService.addPremiere("Снегурочка","Про Снегурочку","0+",42);
        eventService.addPremiere("Кармен", "про Кармен", "12+",52);
        eventService.addPremiere("Евгений Онегин","Про Онегина", "3+", 42);
        eventService.seeAllPremiere();
        eventService.removePremiere("Евгений Онегин");
        eventService.seeAllPremiere();

        eventService.removePremiere("Золушка");

        eventService.viewPremiere("Снегурочка");


    }

}
