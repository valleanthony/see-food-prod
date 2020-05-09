package com.anthonyvalle.seefoodprod.Models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Business_Name")
    private String businessName;
    @Column(name = "City")
    private String city;
    @Column(name = "Zip_Code")
    @Size(min = 5,max = 5)
    private Integer zipCode;
    @Column(name = "Address")
    private String address;
    @Column(name = "Rating" )
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Reviews> reviews;

    private Collection<User> employees;
    private Collection<Items> productsSold;

}
