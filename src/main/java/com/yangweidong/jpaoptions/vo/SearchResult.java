package com.yangweidong.jpaoptions.vo;

public class SearchResult {
    private int tripNumber;
    private String begin;
    private String beginLeaveTime;
    private String end;
    private String endArriveTime;
    private int whetherHaveSeat;
    private int remainSeats;


    public int getRemainSeats() {
        return remainSeats;
    }

    public void setRemainSeats(int remainSeats) {
        this.remainSeats = remainSeats;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "tripNumber=" + tripNumber +
                ", begin='" + begin + '\'' +
                ", beginLeaveTime='" + beginLeaveTime + '\'' +
                ", end='" + end + '\'' +
                ", endArriveTime='" + endArriveTime + '\'' +
                ", whetherHaveSeat=" + whetherHaveSeat +
                ", remainSeats=" + remainSeats +
                '}';
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }



    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getBeginLeaveTime() {
        return beginLeaveTime;
    }

    public void setBeginLeaveTime(String beginLeaveTime) {
        this.beginLeaveTime = beginLeaveTime;
    }

    public String getEndArriveTime() {
        return endArriveTime;
    }

    public void setEndArriveTime(String endArriveTime) {
        this.endArriveTime = endArriveTime;
    }

    public int getWhetherHaveSeat() {
        return whetherHaveSeat;
    }

    public void setWhetherHaveSeat(int whetherHaveSeat) {
        this.whetherHaveSeat = whetherHaveSeat;
    }
}
