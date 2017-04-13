package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public class SeatGroups {

    private final List<SeatGroup> seatGroupList;


    public SeatGroups() {

        seatGroupList = new ArrayList<>();
        for(int row=1; row<=3; row++) {
            for (Lane lane : Lane.values()) {
                seatGroupList.add(new SeatGroup(row, lane));
            }
        }
    }

    public int size() {
        return seatGroupList.size();
    }

    public List<SeatGroup> raw() {
        return seatGroupList;
    }
}
