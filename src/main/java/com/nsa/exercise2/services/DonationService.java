package com.nsa.exercise2.services;

import com.nsa.exercise2.entities.Donation;

import java.util.List;

public interface DonationService {


    public List<Donation> getCharityDonations(Long id);

    public int findAllByCharitySum(Long id);

}
