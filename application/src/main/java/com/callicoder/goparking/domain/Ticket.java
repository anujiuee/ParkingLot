package com.callicoder.goparking.domain;

public class Ticket {
    private int slotNumber;
    private String registrationNumber;
    private String color;
    private int floorNumber;

    public Ticket(int floorNumber,int slotNumber, String registrationNumber, String color) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
