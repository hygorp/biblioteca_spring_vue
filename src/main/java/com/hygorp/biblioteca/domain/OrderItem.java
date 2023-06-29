package com.hygorp.biblioteca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hygorp.biblioteca.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_order_item")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Book book, Integer quantity) {
        super();
        id.setOrder(order);
        id.setBook(book);
        this.quantity = quantity;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    @JsonIgnoreProperties(value = {"authors", "genres"})
    public Book getBook() {
        return id.getBook();
    }

    public void setBook(Book book) {
        id.setBook(book);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubtotal() {
        return getBook().getPrice() * quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        return Objects.equals(id, other.id);
    }
}
