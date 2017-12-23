package com.nsa.exercise2.repositories;

import com.nsa.exercise2.entities.Donation;
import com.nsa.exercise2.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by c1632130 on 31/10/2017.
 */
@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {

    public List<Sponsor> findAllBycharity_id(Long id);

}
