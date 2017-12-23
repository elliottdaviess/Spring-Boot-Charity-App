package com.nsa.exercise2.controllers;


import com.nsa.exercise2.DTO.Activity;
import com.nsa.exercise2.entities.Charity;
import com.nsa.exercise2.entities.Donation;
import com.nsa.exercise2.services.ActionService.ActionService;
import com.nsa.exercise2.services.ActionService.ActionServiceImp;
import com.nsa.exercise2.services.CharityService;
import com.nsa.exercise2.services.CharityServiceImpl;
import com.nsa.exercise2.services.DonationService;
import com.nsa.exercise2.services.DonationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharityController {


    private CharityService CharityImp;
    private DonationService DonationImp;
    private ActionService ActionImp;



    @Autowired
    public CharityController(CharityService aService, DonationService aDonationService, ActionService aActionServiceImp) {
        this.CharityImp = aService;
        this.DonationImp = aDonationService;
        this.ActionImp = aActionServiceImp;
    }


    @RequestMapping("/charities")
    public List<Charity> getCharities() {
        return CharityImp.getCharities();

    }

    //api/charity/12345
    @RequestMapping("charity/{id}")
    public Charity getCharity(@PathVariable Long id) throws NoSuchResourceException {

        Charity aCharity = CharityImp.getCharity(id);

        if (aCharity != null) {
            return aCharity;
        } else
            throw new NoSuchResourceException(); //better to throw exceptions in here than in the Service. Returning null from the Service


        //return CharityImp.getCharity(id);


    }

    @RequestMapping("charity/{id}/donations")
    public List<Donation> getCharityDonations(@PathVariable Long id) throws NoSuchResourceException {

        return DonationImp.getCharityDonations(id);

    }

    @RequestMapping("charity/{id}/donationTotal")
    public int getCharityTotalDonations(@PathVariable Long id) throws NoSuchResourceException {

        return DonationImp.findAllByCharitySum(id)/100;

    }

    @RequestMapping("charity/{id}/recentActivity")
    public List<Activity> getCharityRecentActivity(@PathVariable Long id) throws NoSuchResourceException {

        return ActionImp.getLast10Activities(id);

    }


}
