package com.nsa.exercise2.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "charity")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "charity")
    private List<Donation> donations;

    @JsonIgnore
    @OneToMany(mappedBy = "charity")
    private List<Sponsor> sponsors;


    public Charity(long id1, String test) {
        this.id = id1;
        this.name = test;
    }
}
