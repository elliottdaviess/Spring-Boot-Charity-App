package com.nsa.exercise2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsa.exercise2.DTO.ActivityInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by c1632130 on 31/10/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sponsor_form")
public class Sponsor implements ActivityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "fundraiser_name")
    private String fundraiser_name;

    @Column(name = "fundraising_action")
    private String fundraising_action;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date date_created;

    @Temporal(TemporalType.DATE)
    @Column(name = "first_valid_day")
    private Date first_valid_day;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_valid_day")
    private Date last_valid_day;

    @Column(name = "furl")
    private String furl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @JsonIgnore
    @OneToMany(mappedBy = "sponsor_form")
    private List<Donation> donation;

    @Override
    public String getName() {
        return fundraiser_name;
    }

    @Override
    public String getEvent() {
        return "Created a sponsor form";
    }

    @Override
    public Date getDate() {
        return date_created;
    }
}
