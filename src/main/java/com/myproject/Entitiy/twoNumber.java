package com.myproject.Entitiy;

public class twoNumber {
    private int firstnumber,secondnumber;

    @Override
    public String toString() {
        return "twoNumber{" +
                "firstnumber=" + firstnumber +
                ", secondnumber=" + secondnumber +
                '}';
    }

    public int getFirstnumber() {
        return firstnumber;
    }

    public void setFirstnumber(int firstnumber) {
        this.firstnumber = firstnumber;
    }

    public int getSecondnumber() {
        return secondnumber;
    }

    public void setSecondnumber(int secondnumber) {
        this.secondnumber = secondnumber;
    }

    public twoNumber(int firstnumber, int secondnumber) {
        this.firstnumber = firstnumber;
        this.secondnumber = secondnumber;
    }
}
