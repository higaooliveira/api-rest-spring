package com.higao.apirestspring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {}

    public Payment(Long id, Instant date, Order order) {
        this.id = id;
        this.date = date;
        this.order = order;
    }

    public Long getId() { return this.id; }

    public void setId(long id) { this.id = id; }

    public Instant getDate() { return this.date; }

    public void setDate(Instant date) { this.date = date;}

    public Order getOrder() { return order;}

    public void setOrder(Order order) { this.order = order;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                Objects.equals(date, payment.date) &&
                Objects.equals(order, payment.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, order);
    }
}
