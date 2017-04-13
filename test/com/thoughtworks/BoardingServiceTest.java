package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
@RunWith(MockitoJUnitRunner.class)
public class BoardingServiceTest {


    @Mock
    private ReservationService reservationService;

    @Test
    public void shouldAllocateSeatsAfterCheckingAvailability() {

        List<Seat> expectedSeats = Arrays.asList(new Seat("1A"));
        List<SeatGroup> availableGroups = new ArrayList<SeatGroup>();
        when(reservationService.getAvailability(1)).thenReturn(availableGroups);
        when(reservationService.allocate(availableGroups)).thenReturn(expectedSeats);
        BoardingService boardingService = new BoardingService(reservationService);

        List<Seat> actualSeats = boardingService.allocateSeats(1);

        Assert.assertEquals(expectedSeats, actualSeats);
    }
}
