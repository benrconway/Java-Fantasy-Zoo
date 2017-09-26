package com.example.user.fantasyzooapp;

import com.example.user.fantasyzooapp.outsourcing.RecruitmentAgency;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/09/2017.
 */

public class RecruitmentAgencyTest {

    private RecruitmentAgency rep;

    @Before
    public void before() {
        rep = new RecruitmentAgency();
    }

    @Test
    public void theyHaveAnArray() {
        assertEquals(1, rep.getAwaitingHire().size());
    }
}
