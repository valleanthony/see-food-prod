package com.anthonyvalle.seefoodprod.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column
    private Rating rating;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime timestamp;

    @Lob
    @Column(name="CONTENT", length=1012)
    private String content;

    private User user;

    @ManyToOne()
    private Shop shop;

}
