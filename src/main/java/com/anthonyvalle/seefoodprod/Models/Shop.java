package com.anthonyvalle.seefoodprod.Models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    @Size(min = 5,max = 5)
    private Integer zipCode;
    @Column(name = "address")
    private String address;
    @Column(name = "rating" )
    private Rating rating;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinTable(joinColumns = @JoinColumn(name = "shop_id"), inverseJoinColumns = @JoinColumn(name = "reviews_id"))
    private Collection<Reviews> reviews;

//    private Collection<User> employees;
//    private Collection<Items> productsSold;

}
