package com.anthonyvalle.seefoodprod.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stripe.model.Price;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime timeStamp;

    private String publicOrderId;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "items_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Collection<Items> items;

    private BigDecimal totalAmount;

    @Transient
    private static BigDecimal finalTotalAmount;

    @Transient
    private static final MathContext mathContext = new MathContext(4);

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPublicOrderId() {
        return publicOrderId;
    }

    public void setPublicOrderId(String publicOrderId) {
        this.publicOrderId = publicOrderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Items> getItems() {
        return items;
    }

    public void setItems(Collection<Items> items) {
        this.items = items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void generatePublicId(){
        this.publicOrderId = UUID.randomUUID().toString()
                .replace("-","");
    }

    public void getFinalAmount(){
     for (Items unit: this.getItems()){
         finalTotalAmount.add(unit.getPrice(),mathContext);
     }
     this.totalAmount = finalTotalAmount;
    }
}
