package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderItemTest {

    @Test
    @DisplayName("Test 1: Create order")

    public void test1(){
        Product product1 = new Product();
        product1.setName("Computer");
        product1.setPrice(19500.50);

        OrderItem createOrder = new OrderItem();
        createOrder.setProduct(product1);
        createOrder.setQuantity(10);

        Assertions.assertEquals("Computer", createOrder.getProduct().getName());
    }

    @Test
    @DisplayName("Test 2: Calculate price")

    public void test2 (){
        Product product1 = new Product();
        product1.setName("Computer");
        product1.setPrice(19500.50);

        OrderItem createOrder = new OrderItem();
        createOrder.setProduct(product1);
        createOrder.setQuantity(10);

        double expected = 19500.50 * 3;

        Assertions.assertEquals(expected,createOrder.calculatePrice(product1, 3) );
    }

}
