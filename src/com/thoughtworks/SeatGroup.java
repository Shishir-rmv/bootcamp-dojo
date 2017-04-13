package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public class SeatGroup {
    private int row;
    private Lane lane;



    public SeatGroup(int row, Lane lane) {
        this.row = row;
        this.lane = lane;
    }

    public int getRow() {
        return row;
    }

    public Lane getLane() {
        return this.lane;
    }

    public List<Seat> seats() {

        return Arrays.stream(lane.seatSeries())
                .map(s -> new Seat(row + s))
                .collect(Collectors.toList());
    }
}
