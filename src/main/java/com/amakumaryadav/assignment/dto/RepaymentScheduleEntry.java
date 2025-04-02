package com.amakumaryadav.assignment.dto;

public class RepaymentScheduleEntry {
    private int sno;
    private String date;
    private String day;
    private double outstandingStart;
    private double dueInterest;
    private double emi;
    private double outstandingEnd;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getOutstandingStart() {
        return outstandingStart;
    }

    public void setOutstandingStart(double outstandingStart) {
        this.outstandingStart = outstandingStart;
    }

    public double getDueInterest() {
        return dueInterest;
    }

    public void setDueInterest(double dueInterest) {
        this.dueInterest = dueInterest;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public double getOutstandingEnd() {
        return outstandingEnd;
    }

    public void setOutstandingEnd(double outstandingEnd) {
        this.outstandingEnd = outstandingEnd;
    }

    public RepaymentScheduleEntry() {
    }

    public RepaymentScheduleEntry(int sno, String date, String day, double outstandingStart, double dueInterest, double emi, double outstandingEnd) {
        this.sno = sno;
        this.date = date;
        this.day = day;
        this.outstandingStart = outstandingStart;
        this.dueInterest = dueInterest;
        this.emi = emi;
        this.outstandingEnd = outstandingEnd;
    }
}