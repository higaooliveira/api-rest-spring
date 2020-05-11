package com.higao.apirestspring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.higao.apirestspring.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;

    private int orderStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private User customer;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order (){}

    public Order(Long id, Instant date,  OrderStatus orderStatus, User customer) {
        this.id = id;
        this.date = date;
        this.setOrderStatus(orderStatus);
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getCustomer() {
        return this.customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public Payment getPayment() { return this.payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public Set<OrderItem> getItems() {return this.items;}

    public Double getTotal(){
        double total = 0.0;

        for(OrderItem item: this.items){
            total += item.getSubTotal();
        }

        return total;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                date.equals(order.date) &&
                customer.equals(order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer);
    }
}
