package com.nsa.exercise2.repositories;

import com.nsa.exercise2.entities.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharityRepository extends JpaRepository<Charity, Long> {

    public List<Charity> findAll();

    public Charity findById(Long id);

}
