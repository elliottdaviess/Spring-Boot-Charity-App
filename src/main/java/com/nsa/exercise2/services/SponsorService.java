package com.nsa.exercise2.services;

import com.nsa.exercise2.entities.Sponsor;

import java.util.List;

/**
 * Created by c1632130 on 31/10/2017.
 */
public interface SponsorService {

    public List<Sponsor> findAllBycharity_id(Long id);

}
