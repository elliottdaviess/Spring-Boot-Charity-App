package com.nsa.exercise2.repositories;

import com.nsa.exercise2.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {


    public List<Donation> findAllBycharity_id(Long id);

    @Query(value = "SELECT SUM(amount_in_pence)FROM donation WHERE charity_id = :charity_id", nativeQuery = true)

    int findAllByCharitySum(@Param("charity_id")Long charity_id);

}
