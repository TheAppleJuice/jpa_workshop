package se.lexicon.jpa_workshop.entity;


import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

public class OrderItem {
    private int Id;
    private int quantity;
    private Product product;
    @ManyToOne
    @JoinColumn(name = "productOrder_id")
    private ProductOrder productOrder;

    public OrderItem() {

    }

    public double calculatePrice (Product product, int quantity){
        return product.getPrice() * quantity;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Id == orderItem.Id && quantity == orderItem.quantity && Objects.equals(product, orderItem.product) && Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, quantity, product, productOrder);
    }
}
