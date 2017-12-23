package com.nsa.exercise2.services;

import com.nsa.exercise2.entities.Donation;
import com.nsa.exercise2.entities.Sponsor;
import com.nsa.exercise2.repositories.DonationRepository;
import com.nsa.exercise2.repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by c1632130 on 31/10/2017.
 */
@Service
public class SponsorServiceImpl implements SponsorService{

    @Qualifier("JPA")
    private SponsorRepository aSponsorRepository;

    @Autowired
    public SponsorServiceImpl(SponsorRepository aRepo) {
        aSponsorRepository = aRepo;
    }

    @Override
    public List<Sponsor> findAllBycharity_id(Long id) {
        List<Sponsor> returnSponsors = aSponsorRepository.findAllBycharity_id(id);

        if (returnSponsors != null) {
            return returnSponsors;
        } else {
            return null;
        }
    }
}
