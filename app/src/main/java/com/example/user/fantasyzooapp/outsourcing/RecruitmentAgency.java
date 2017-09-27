package com.example.user.fantasyzooapp.outsourcing;

import com.example.user.fantasyzooapp.people.Keeper;
import com.example.user.fantasyzooapp.people.Staff;

import java.util.ArrayList;

/**
 * Created by user on 25/09/2017.
 */

public class RecruitmentAgency {
    private ArrayList<Staff> awaitingHire;

    public RecruitmentAgency(){
        this.awaitingHire = new ArrayList<>();
        setUpStaffApplications();
    }

    public ArrayList<Staff> getAwaitingHire() {
        return awaitingHire;
    }

    public void setUpStaffApplications() {
        Keeper staff = new Keeper(300, 50, 65);
        awaitingHire.add(staff);
    }

    public Staff transferStaff() {
       return awaitingHire.get(0);
    }
}
