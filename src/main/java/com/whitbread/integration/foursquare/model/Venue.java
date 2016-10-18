package com.whitbread.integration.foursquare.model;

/**
 * Created by hakankurtulus on 17/10/2016.
 */
public class Venue {
    private String name;

    private String longitude;

    private String latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (name != null ? !name.equals(venue.name) : venue.name != null) return false;
        if (longitude != null ? !longitude.equals(venue.longitude) : venue.longitude != null) return false;
        return latitude != null ? latitude.equals(venue.latitude) : venue.latitude == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }
}
