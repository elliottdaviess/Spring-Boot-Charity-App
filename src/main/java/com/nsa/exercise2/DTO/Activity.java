package com.nsa.exercise2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by c1632130 on 31/10/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private String name;
    private String action;
    private Date date;
}
