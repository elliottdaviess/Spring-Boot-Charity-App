package com.nsa.exercise2.services.ActionService;

import com.nsa.exercise2.DTO.Activity;
import com.nsa.exercise2.DTO.ActivityInterface;
import com.nsa.exercise2.entities.Donation;
import com.nsa.exercise2.entities.Sponsor;
import com.nsa.exercise2.services.DonationService;
import com.nsa.exercise2.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActionServiceImp implements ActionService {


    @Qualifier("JPA")

    private DonationService aDonationImp;
    private SponsorService aSponsorImp;

    @Autowired
    public ActionServiceImp(DonationService aDonationImplementation, SponsorService aSponsorImplementation) {
        aDonationImp = aDonationImplementation;
        aSponsorImp = aSponsorImplementation;
    }


    @Override
    public List<Sponsor> getAllSponsors(Long charityid) {
        return aSponsorImp.findAllBycharity_id(charityid);
    }

    @Override
    public List<Donation> getAllDonations(Long charityid) {
        return aDonationImp.getCharityDonations(charityid);
    }

    @Override
    public List<Activity> getLast10Activities(Long charityid) {
        getAllDonations(charityid);

        List<Donation> allDonations = new ArrayList<Donation>();
        List<Sponsor> allSponsors = new ArrayList<Sponsor>();


        allDonations.addAll(aDonationImp.getCharityDonations(charityid));
        allSponsors.addAll(aSponsorImp.findAllBycharity_id(charityid));

        List<ActivityInterface> Activities =  new ArrayList<ActivityInterface>();

        Activities.addAll(allDonations);
        Activities.addAll(allSponsors);


        List<Activity> result =
                                Activities.stream() //Assign result to List of Actvities - result. Stream List of ActivityInterface -  Activities.
                                .map(activityInterface -> new Activity(activityInterface.getName(), activityInterface.getEvent(), activityInterface.getDate())) //for each, ActivityInterface, use getters and assign to new Activity object.
                                .sorted(Comparator.comparing(Activity::getDate).reversed()) //order by Date from new Activity just created(^^) in reverse order
                                .limit(10).collect(Collectors.toList()); //limit to 10 activities in result.
        return result;

       // return null;


    }
}
