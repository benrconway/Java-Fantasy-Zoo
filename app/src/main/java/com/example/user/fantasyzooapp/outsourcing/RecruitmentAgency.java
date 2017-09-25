package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class RecruitmentAgency {
    private Staff staff;
    private ArrayList<Staff> awaitingHire;

    public RecruitmentAgency(){
        this.awaitingHire = new ArrayList<>();
        setUpStaffApplications();
    }

    public void setUpStaffApplications() {
        staff = new Staff(300, 50, 65);
        awaitingHire.add(staff);
    }
}
