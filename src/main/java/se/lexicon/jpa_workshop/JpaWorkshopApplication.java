package se.lexicon.jpa_workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.OrderItem;
import se.lexicon.jpa_workshop.entity.Product;
import se.lexicon.jpa_workshop.entity.ProductOrder;

@SpringBootApplication
public class JpaWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWorkshopApplication.class, args);

    }

}
