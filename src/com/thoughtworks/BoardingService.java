package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public class BoardingService {
    private ReservationService reservationService;

    public BoardingService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<Seat> allocateSeats(int passengers) {
        List<SeatGroup> groups = reservationService.getAvailability(passengers);
        return reservationService.allocate(groups);
    }
}
