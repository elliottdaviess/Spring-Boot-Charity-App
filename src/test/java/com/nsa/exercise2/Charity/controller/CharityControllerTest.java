package com.nsa.exercise2.Charity.controller;

/**
 * Created by c1632130 on 04/11/2017.
 */

import com.nsa.exercise2.controllers.CharityController;
import com.nsa.exercise2.entities.Charity;
import com.nsa.exercise2.services.ActionService.ActionService;
import com.nsa.exercise2.services.CharityService;
import com.nsa.exercise2.services.DonationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(CharityController.class)
public class CharityControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CharityService aService;

    @MockBean
    DonationService aDonationService;

    @MockBean
    ActionService aActionServiceImp;


    @Test
    public void expectToSeeAllCharityNamesInResponse() throws Exception {

        long id1 = 1L;
        long id2 = 2L;
        Charity a = new Charity(id1, "CharityA");
        Charity b = new Charity(id2, "CharityB");
        List<Charity> testList = new ArrayList<>();
        testList.add(a);
        testList.add(b);


        when(aService.getCharities()).thenReturn(testList);
        this.mvc.perform(get("/api/charities")).andExpect(status().isOk())
                .andExpect(content().string(containsString("CharityA")))
                .andExpect(content().string(containsString("CharityB")));

    }

    @Test
    public void expectToSeeNoSuchResourceExceptionThrown() throws Exception { //unhappy path

        long id1 = 1L;
        long id2 = 2L;
        Charity a = new Charity(id1, "CharityA");
        Charity b = new Charity(id2, "CharityB");
        List<Charity> testList = new ArrayList<>();
        testList.add(a);
        testList.add(b);

        when(aService.getCharities()).thenReturn(testList);
        this.mvc.perform(get("/api/charity/999"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No resource available on this URL")));

    }

//    @Test
//    public void test() throws Exception {
//
//        int totalAmount = 1;
//
//
//        given(this.aDonationService.findAllByCharitySum(1L)).willReturn((totalAmount));
//        this.mvc.perform(get("/api/charity/2/donationTotal")).andExpect(status().isOk())
//                .andExpect(content().string(containsString("1")));
//    }
}

