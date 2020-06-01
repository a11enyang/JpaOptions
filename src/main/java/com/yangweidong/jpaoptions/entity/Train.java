package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_train_id")
    private int trainId;

    @Column(name = "c_train_type")
    private String trainType;//火车类型

    @Column(name = "c_train_number")
    private int trainSeatNumber;//火车的座位数量

    @Column(name = "c_train_checked")
    private boolean trainChecked;//火车是否被选择


    @OneToOne(targetEntity = Trip.class)
    @JoinColumn(name = "c_train_trip_fk", referencedColumnName = "c_trip_id")
    private Trip trainTrip;


    public Trip getTrainTrip() {
        return trainTrip;
    }

    public void setTrainTrip(Trip trainTrip) {
        this.trainTrip = trainTrip;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getTrainSeatNumber() {
        return trainSeatNumber;
    }

    public void setTrainSeatNumber(int trainSeatNumber) {
        this.trainSeatNumber = trainSeatNumber;
    }

    public boolean isTrainChecked() {
        return trainChecked;
    }

    public void setTrainChecked(boolean trainChecked) {
        this.trainChecked = trainChecked;
    }
}
