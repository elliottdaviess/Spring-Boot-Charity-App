package com.nsa.exercise2.services;

import com.nsa.exercise2.entities.Charity;

import java.util.List;

public interface CharityService {

    public List<Charity> getCharities();

    public Charity getCharity(Long id);

}
