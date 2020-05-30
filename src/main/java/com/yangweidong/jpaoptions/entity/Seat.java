package com.yangweidong.jpaoptions.entity;

import jdk.nashorn.internal.ir.BlockLexicalContext;

import javax.persistence.*;

@Entity
@Table(name = "t_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_seat_id")
    private int seatId;

    @Column(name = "c_seat_first_station")
    private String seatFirstStation;

    @Column(name = "c_seat_second_station")
    private String seatSecondStation;

    @Column(name = "c_seat_binary_number")
    private String seatBinaryNumber;

    @Column(name = "c_seat_whether_have_empty")
    private int seatWhetherHaveEmpty;

    @Column(name = "c_seat_sequence")
    private int seatSequence;

    @ManyToOne(targetEntity = Trip.class)
    @JoinColumn(name = "c_seat_trip_fk", referencedColumnName = "c_trip_id")
    private Trip seatTrip;


    public Trip getSeatTrip() {
        return seatTrip;
    }

    public void setSeatTrip(Trip seatTrip) {
        this.seatTrip = seatTrip;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatFirstStation() {
        return seatFirstStation;
    }

    public void setSeatFirstStation(String seatFirstStation) {
        this.seatFirstStation = seatFirstStation;
    }

    public String getSeatSecondStation() {
        return seatSecondStation;
    }

    public void setSeatSecondStation(String seatSecondStation) {
        this.seatSecondStation = seatSecondStation;
    }

    public String getSeatBinaryNumber() {
        return seatBinaryNumber;
    }

    public void setSeatBinaryNumber(String seatBinaryNumber) {
        this.seatBinaryNumber = seatBinaryNumber;
    }

    public int getSeatWhetherHaveEmpty() {
        return seatWhetherHaveEmpty;
    }

    public void setSeatWhetherHaveEmpty(int seatWhetherHaveEmpty) {
        this.seatWhetherHaveEmpty = seatWhetherHaveEmpty;
    }

    public int getSeatSequence() {
        return seatSequence;
    }

    public void setSeatSequence(int seatSequence) {
        this.seatSequence = seatSequence;
    }
}
