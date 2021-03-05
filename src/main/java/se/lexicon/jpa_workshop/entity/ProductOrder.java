package se.lexicon.jpa_workshop.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProductOrder {
    private int Id;
    private LocalDateTime orderDateTime;

    @OneToMany (mappedBy = "productOrder")
    private List<OrderItem> orderItems;
    private AppUser customer;

    public void addOrderItem (OrderItem orderItem){
        if (orderItems == null){
            orderItems = new ArrayList<>();
        }
        orderItem.setProductOrder(this);
        orderItems.add(orderItem);

    }

    public void removeOrderItem (OrderItem orderItem){
        if (orderItem != null) {
            orderItem.setProduct(null);
            orderItems.remove(orderItem);
        }

    }

    public double calculateTotalPrice (List<OrderItem> orderItems){
        double sum =orderItems.stream().
                map(orderItem -> orderItem.calculatePrice(orderItem.getProduct(), orderItem.getQuantity())).
                reduce(0.0, Double::sum);
        return sum;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return Id == that.Id && Objects.equals(orderDateTime, that.orderDateTime) && Objects.equals(orderItems, that.orderItems) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, orderDateTime, orderItems, customer);
    }
}
