package com.nsa.exercise2.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nsa.exercise2.DTO.ActivityInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donation")
public class Donation implements ActivityInterface {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "amount_in_pence")
    private int amountInPence;

    @Column(name = "donation_date")
    @Temporal(TemporalType.DATE)
    private Date donationDate;

    @Column(name = "is_own_money")
    private boolean ownMoney;

    @Column(name = "has_no_benefit_to_donor")
    private boolean hasNoBenefitToDonor;

    @Column(name = "wishes_to_gift_aid")
    private boolean wishesToGiftAid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sponsor_form_id")
    private Sponsor sponsor_form;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;


    @Override
    public String getName() {
        return this.donor.getName();
    }

    @Override
    public String getEvent() {
        return "Donated: £" + amountInPence/100;
    }

    @Override
    public Date getDate() {
        return donationDate;
    }
}





