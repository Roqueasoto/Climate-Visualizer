package com.climate.climatevisualizer.web;

/**
 * A class to store climate index search results.
 */
public class ClimateResults {
    private double lat;
    private double lon;

    public ClimateResults(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
