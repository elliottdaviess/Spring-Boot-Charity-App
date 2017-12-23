package com.nsa.exercise2.services;

import com.nsa.exercise2.controllers.NoSuchResourceException;
import com.nsa.exercise2.repositories.CharityRepository;
import com.nsa.exercise2.entities.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CharityServiceImpl implements CharityService {
    @Qualifier("JPA")
    private CharityRepository aCharityRepository;

    @Autowired
    public CharityServiceImpl(CharityRepository aRepo) {
        aCharityRepository = aRepo;
    }

    @Override
    public List<Charity> getCharities() {
        return aCharityRepository.findAll();
    }

    @Override
    public Charity getCharity(Long id) {

        Charity returnCharity = aCharityRepository.findById(id);

        if (returnCharity != null) {
            return returnCharity;
        } else {
            return null;
        }
    }
}
