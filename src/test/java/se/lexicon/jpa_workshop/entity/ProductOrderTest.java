package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {


    List<OrderItem> expectedProductOrderList;
    //AppUser appUser1;
    AppUser testAppUser;
    ProductOrder testProductOrder;

    //OrderItem createOrderItem1;
    //OrderItem createOrderItem2;

    @BeforeEach
    public void setup() {
        AppUser appUser1 = new AppUser();
        appUser1.setFirstName("Sebastian");
        appUser1.setLastName("Bocaciu");
        appUser1.setEmail("sebo@gmail.com");

        Product createProduct1 = new Product();
        createProduct1.setPrice(19500.50);
        createProduct1.setName("Computer");

        Product createProduct2 = new Product();
        createProduct2.setPrice(6500);
        createProduct2.setName("Monitor");

        OrderItem createOrderItem1 = new OrderItem();
        createOrderItem1.setProduct(createProduct1);
        createOrderItem1.setQuantity(1);


        OrderItem createOrderItem2 = new OrderItem();
        createOrderItem2.setProduct(createProduct2);
        createOrderItem2.setQuantity(2);

        /*List<OrderItem> expectedProductOrderList = new ArrayList<>();
        expectedProductOrderList.add(createOrderItem1);
        expectedProductOrderList.add(createOrderItem2);*/

        testProductOrder = new ProductOrder();
        testProductOrder.setCustomer(appUser1);
        testProductOrder.addOrderItem(createOrderItem1);
        testProductOrder.addOrderItem(createOrderItem2);
        testProductOrder.setOrderDateTime(LocalDateTime.now());

        //REMOVE ORDER
        testProductOrder.removeOrderItem(createOrderItem1);



    }


    @Test
    @DisplayName("Test 1: Add order item")
    public void test1() {



        Assertions.assertEquals(19500.50, testProductOrder.getOrderItems().get(0).getProduct().getPrice());

    }

    @Test
    @DisplayName("Test 2: Remove order item")
    public void test2() {


        Assertions.assertEquals(6500, testProductOrder.getOrderItems().get(0).getProduct().getPrice());

    }

    @Test
    @DisplayName("Test 3: Calculate total price")
    public void test3() {


        Assertions.assertEquals(13000, testProductOrder.calculateTotalPrice(testProductOrder.getOrderItems()));



    }
}