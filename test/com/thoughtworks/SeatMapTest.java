package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public class SeatMapTest {

    @Test
    public void shouldInitializeSeatMapWithNineSeatGroups() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();

        Assert.assertEquals(9, groups.size());
    }

    @Test
    public void shouldInitializeEachSeatGroupWithRowNumbers() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();
        List<SeatGroup> seatGroupList = groups.raw();

        Assert.assertEquals(3, seatGroupsWithRow(seatGroupList, 1).count());
        Assert.assertEquals(3, seatGroupsWithRow(seatGroupList, 2).count());
        Assert.assertEquals(3, seatGroupsWithRow(seatGroupList, 3).count());
    }


    @Test
    public void shouldInitializeEachSeatGroupWithLane() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();
        List<SeatGroup> seatGroupList = groups.raw();

        List<SeatGroup> firstRow = seatGroupsWithRow(seatGroupList, 1).collect(Collectors.toList());
        Assert.assertEquals(1, seatGroupsWithLane(firstRow, Lane.Left).count());
        Assert.assertEquals(1, seatGroupsWithLane(firstRow, Lane.Middle).count());
        Assert.assertEquals(1, seatGroupsWithLane(firstRow, Lane.Right).count());
    }

    @Test
    public void shouldInitializeLeftLaneGroupsWithTwoSeats() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();
        List<SeatGroup> seatGroupList = groups.raw();

        SeatGroup leftLaneOfFirstRow = seatGroupWith(seatGroupList, 1, Lane.Left);
        List<Seat> seats = leftLaneOfFirstRow.seats();

        Assert.assertEquals(2, seats.size());
        Assert.assertEquals("1A", seats.get(0).id());
        Assert.assertEquals("1B", seats.get(1).id());
    }

    @Test
    public void shouldInitializeMiddleLaneGroupsWithFourSeats() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();
        List<SeatGroup> seatGroupList = groups.raw();

        SeatGroup middleLaneGroup = seatGroupWith(seatGroupList, 2, Lane.Middle);
        List<Seat> seats = middleLaneGroup.seats();

        Assert.assertEquals(4, seats.size());
        Assert.assertEquals("2C", seats.get(0).id());
        Assert.assertEquals("2D", seats.get(1).id());
        Assert.assertEquals("2E", seats.get(2).id());
        Assert.assertEquals("2F", seats.get(3).id());
    }

    @Test
    public void shouldInitializeRightLaneGroupsWithTwoSeats() {

        SeatMap seatMap = new SeatMap();

        SeatGroups groups = seatMap.allSeatGroups();
        List<SeatGroup> seatGroupList = groups.raw();

        SeatGroup rightLaneGroup = seatGroupWith(seatGroupList, 3, Lane.Right);
        List<Seat> seats = rightLaneGroup.seats();

        Assert.assertEquals(2, seats.size());
        Assert.assertEquals("3G", seats.get(0).id());
        Assert.assertEquals("3H", seats.get(1).id());
    }

    private SeatGroup seatGroupWith(List<SeatGroup> seatGroupList, int row, Lane lane) {
        return seatGroupList.stream().filter(g -> g.getRow() == row && g.getLane() == lane).findFirst().get();
    }

    private Stream<SeatGroup> seatGroupsWithLane(List<SeatGroup> row, Lane lane) {
        return row.stream().filter(r -> r.getLane() == lane);
    }

    private Stream<SeatGroup> seatGroupsWithRow(List<SeatGroup> seatGroupList, int row) {
        return seatGroupList.stream().filter(sg -> sg.getRow() == row);
    }
}
