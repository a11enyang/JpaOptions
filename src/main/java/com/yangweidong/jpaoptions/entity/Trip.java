package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_trip")
public class Trip {
    @Id
    @Column(name = "c_trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;

    @Column(name = "c_trip_number")
    private int tripNumber;

    @Column(name = "c_trip_status")
    private boolean tripStatus;

    @Column(name = "c_trip_line")
    private String tripLine;

    /**
     * 映射关系
     */
    @OneToOne(mappedBy = "trainTrip")
    private Train tripTrain;

    @OneToMany(targetEntity = Station.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_station_trip_fk", referencedColumnName = "c_trip_id")
    private Set<Station> tripStations = new HashSet<>();

    @OneToMany(targetEntity = Seat.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_seat_trip_fk", referencedColumnName = "c_trip_id")
    private Set<Seat> tripSeats = new HashSet<>();


    public Set<Station> getTripStations() {
        return tripStations;
    }

    public void setTripStations(Set<Station> tripStations) {
        this.tripStations = tripStations;
    }

    public Set<Seat> getTripSeats() {
        return tripSeats;
    }

    public void setTripSeats(Set<Seat> tripSeats) {
        this.tripSeats = tripSeats;
    }

    public Train getTripTrain() {
        return tripTrain;
    }

    public void setTripTrain(Train tripTrain) {
        this.tripTrain = tripTrain;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public boolean isTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(boolean tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getTripLine() {
        return tripLine;
    }

    public void setTripLine(String tripLine) {
        this.tripLine = tripLine;
    }
}
