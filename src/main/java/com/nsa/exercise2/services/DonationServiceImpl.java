package com.nsa.exercise2.services;

import com.nsa.exercise2.repositories.DonationRepository;
import com.nsa.exercise2.entities.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DonationServiceImpl implements DonationService {
    @Qualifier("JPA")
    private DonationRepository aDonationRepository;

    @Autowired
    public DonationServiceImpl(DonationRepository aRepo) {
        aDonationRepository = aRepo;
    }

    @Override
    public List<Donation> getCharityDonations(Long id) {

        List<Donation> returnDonations = aDonationRepository.findAllBycharity_id(id);

        if (returnDonations != null) {
            return returnDonations;
        } else {
            return null;
        }
    }

    @Override
    public int findAllByCharitySum(Long id) {
        return aDonationRepository.findAllByCharitySum(id);
    }
}
