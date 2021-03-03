package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppUserTest {



    @Test
    @DisplayName("Test 1: Create App user")

    public void test1(){
        AppUser createUser = new AppUser();
        createUser.setFirstName("Sebastian");
        createUser.setLastName("Bocaciu");
        createUser.setEmail("sebo@gmail.com");

        // Assertions.assertEquals("Sebastian", createUser.getFirstName());
        // Assertions.assertEquals("sebo@gmail.com", createUser.getEmail());
        Assertions.assertEquals("Bocaciu", createUser.getLastName());

    }
}
