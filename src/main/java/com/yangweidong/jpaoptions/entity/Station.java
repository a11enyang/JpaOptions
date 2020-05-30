package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_station")
public class Station {
    @Id
    @Column(name = "c_station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationId;

    @Column(name = "c_station_name")
    private String stationName;

    @Column(name = "c_station_arrive_time")
    private String stationArriveTime;

    @Column(name = "c_station_leave_time")
    private String stationLeaveTime;

    @Column(name = "c_station_sequence")
    private int stationSequence;

    @ManyToOne(targetEntity = Trip.class)
    @JoinColumn(name = "c_station_trip_fk", referencedColumnName = "c_trip_id")
    private Trip stationTrip;


    public Trip getStationTrip() {
        return stationTrip;
    }

    public void setStationTrip(Trip stationTrip) {
        this.stationTrip = stationTrip;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationArriveTime() {
        return stationArriveTime;
    }

    public void setStationArriveTime(String stationArriveTime) {
        this.stationArriveTime = stationArriveTime;
    }

    public String getStationLeaveTime() {
        return stationLeaveTime;
    }

    public void setStationLeaveTime(String stationLeaveTime) {
        this.stationLeaveTime = stationLeaveTime;
    }

    public int getStationSequence() {
        return stationSequence;
    }

    public void setStationSequence(int stationSequence) {
        this.stationSequence = stationSequence;
    }
}
