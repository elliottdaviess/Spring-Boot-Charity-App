package com.nsa.exercise2.Charity.controller;

import com.nsa.exercise2.entities.Charity;
import com.nsa.exercise2.repositories.CharityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by c1632130 on 04/11/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CharityRepostitoryTest {

    @Autowired
    private CharityRepository CharityRepository;

    long i = 1L;

    @Test
    public void SaveTest() throws Exception {
        CharityRepository.save(new Charity(i, "Test"));
    }


    @Test
    public void saveTestNotNull() {

        Charity user = new Charity(i, "TestCharity");
        CharityRepository.save(user);
        Assert.assertNotNull(CharityRepository.findOne(i));
    }

    @Test
    public void RepoHasData(){
        List<Charity> chars = CharityRepository.findAll();
        assertThat(chars).isNotEmpty();
    }

    @Test
    public void findCharitybyIDNotNull(){
        Charity charity = CharityRepository.findById(1L);
        assertThat(charity).isNotNull();
    }

    @Test
    public void findCharitybyID_IsNull(){
        Charity charity = CharityRepository.findById(93838L);
        assertThat(charity).isNull();
    }




}




