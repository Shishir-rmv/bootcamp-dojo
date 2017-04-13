package com.thoughtworks;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public class Seat {
    private String id;

    public Seat(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Seat)obj).id.equals(this.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
