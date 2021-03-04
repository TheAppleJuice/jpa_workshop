package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Test
    @DisplayName("Test 1: Create Product")

    public void test1 (){
        Product createProduct = new Product();
        createProduct.setPrice(19500.50);
        createProduct.setName("Computer");

       // Assertions.assertEquals("Computer", createProduct.getName());
        Assertions.assertEquals(19500.50, createProduct.getPrice());
    }


}
