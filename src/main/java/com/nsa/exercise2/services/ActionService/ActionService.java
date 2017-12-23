package com.nsa.exercise2.services.ActionService;

import com.nsa.exercise2.DTO.Activity;
import com.nsa.exercise2.entities.Donation;
import com.nsa.exercise2.entities.Sponsor;

import java.util.List;

/**
 * Created by c1632130 on 31/10/2017.
 */
public interface ActionService {

    List<Sponsor> getAllSponsors(Long charityid);

    List<Donation> getAllDonations(Long charityid);

    List<Activity> getLast10Activities(Long charityid);
}
