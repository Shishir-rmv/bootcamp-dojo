package com.thoughtworks;

/**
 * Created by kumar.iyer on 13-Apr-17.
 */
public enum Lane {
    Left(new String[]{"A", "B"}),
    Right(new String[]{"G", "H"}),
    Middle(new String[]{"C", "D", "E", "F"});

    private String[] series;

    Lane(String[] series) {
        this.series = series;
    }

    public String[] seatSeries() {
        return series;
    }
}
