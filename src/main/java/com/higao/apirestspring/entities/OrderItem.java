package com.higao.apirestspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.higao.apirestspring.entities.pk.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUI = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem() {}

    public OrderItem(Order order, Product product, int quantity, double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;

    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return this.id.getOrder();
    }

    public void setOrder(Order order){ this.id.setOrder(order); }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public void setOrder(Product product){
        this.id.setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
