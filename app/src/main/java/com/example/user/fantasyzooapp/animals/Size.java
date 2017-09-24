package com.example.user.fantasyzooapp.animals;

/**
 * Created by user on 22/09/2017.
 */

public enum Size {
    SMALL(0),
    MEDIUM(1),
    LARGE(2),
    HUGE(3);

    private final int value;

    Size(int value) {
        this.value = value;
    }
}
