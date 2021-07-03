package com.callicoder.goparking.domain;

import com.callicoder.goparking.exceptions.ParkingLotFullException;
import com.callicoder.goparking.exceptions.SlotAlredayEmptyException;
import com.callicoder.goparking.exceptions.SlotNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    private final int numSlots;
    private final int numFloors;
    private SortedSet<ParkingSlot> availableSlots = new TreeSet<>();
    private Set<ParkingSlot> occupiedSlots = new HashSet<>();

    public ParkingLot(int numFloors, int numSlots) {
        if(numSlots <= 0) {
            throw new IllegalArgumentException("Number of slots in the Parking Lot must be greater than zero.");
        }

        // Assuming Single floor since only numSlots are specified in the input.
        this.numSlots = numSlots;
        this.numFloors = 1;

        for (int j=0;j<numFloors;j++){
        for(int i = 0; i < numSlots; i++) {
            ParkingSlot parkingSlot = new ParkingSlot(i + 1, j+1);
            this.availableSlots.add(parkingSlot);
          }
        }
    }

    public synchronized Ticket reserveSlot(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car must not be null");
        }

        if(this.isFull()) {
            throw new ParkingLotFullException();
        }

        ParkingSlot nearestSlot = this.availableSlots.first();

        nearestSlot.reserve(car);
        this.availableSlots.remove(nearestSlot);
        this.occupiedSlots.add(nearestSlot);

        return new Ticket(nearestSlot.getFloorNumber(),nearestSlot.getSlotNumber(), car.getRegistrationNumber(), car.getColor());
    }

    public ParkingSlot leaveSlot(int slotNumber) {
        //TODO: implement leave

        if(slotNumber<1 || slotNumber>numSlots) throw new SlotNotFoundException(slotNumber);
        ParkingSlot parkingSlot = new ParkingSlot(slotNumber,1);

        if(availableSlots.contains(parkingSlot)) throw new SlotAlredayEmptyException(slotNumber);
        parkingSlot.clear();
        occupiedSlots.remove(parkingSlot);
        availableSlots.add(parkingSlot);

        return parkingSlot;
    }

    public boolean isFull() {
        return this.availableSlots.isEmpty();
    }

    public List<String> getRegistrationNumbersByColor(String color) {
        //TODO: implement getRegistrationNumbersByColor

        return occupiedSlots.stream().filter(x->x.getCar().getColor().equals(color)).map(x->x.getCar().getRegistrationNumber()).collect(Collectors.toList());
    }

    public List<Integer> getSlotNumbersByColor(String color) {
        //TODO: implement getSlotNumbersByColor

        return occupiedSlots.stream().filter(x->x.getCar().getColor().equals(color)).map(x->x.getSlotNumber()).collect(Collectors.toList());

    }

    public Optional<Integer> getSlotNumberByRegistrationNumber(String registrationNumber) {
        //TODO: implement getSlotNumberByRegistrationNumber

        Optional<Integer> slotNum = Optional.empty();


        //occupiedSlots.stream().filter(x->x.getCar().getRegistrationNumber().equals(registrationNumber)).map(x->x.getSlotNumber()).collect(Collectors.toList()).get(0);

        for (ParkingSlot parkingSlot:occupiedSlots){
            if(parkingSlot.getCar().getRegistrationNumber().equals(registrationNumber)){
                slotNum = Optional.of(parkingSlot.getSlotNumber());
            }
        }

        return slotNum;
    }


    public int getNumSlots() {
        return numSlots;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public SortedSet<ParkingSlot> getAvailableSlots() {
        return availableSlots;
    }

    public Set<ParkingSlot> getOccupiedSlots() {
        return occupiedSlots;
    }
}
