package com.anthonyvalle.seefoodprod.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private String productDescription;
    private boolean available;
    private Rating rating;
    private Collection<String> imageUrl;

}
