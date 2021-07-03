package com.callicoder.goparking.handler;

import com.callicoder.goparking.exceptions.ParkingLotFullException;
import com.callicoder.goparking.domain.Car;
import com.callicoder.goparking.domain.ParkingLot;
import com.callicoder.goparking.domain.Ticket;
import com.callicoder.goparking.utils.StringUtils;

import java.util.Optional;

import static com.callicoder.goparking.utils.MessageConstants.*;

public class ParkingLotCommandHandler {
    private ParkingLot parkingLot;

    public void createParkingLot(int numFloors, int numSlots) {
        if(isParkingLotCreated()) {
            System.out.println(PARKING_LOT_ALREADY_CREATED);
            return;
        }

        try {
            parkingLot = new ParkingLot(numFloors, numSlots);
            System.out.println(String.format(PARKING_LOT_CREATED_MSG, parkingLot.getNumSlots()));
        } catch (IllegalArgumentException ex) {
            System.out.println("Bad input: " + ex.getMessage());
        }
    }

    public void park(String registrationNumber, String color) {
        if(!isParkingLotCreated()) {
            System.out.println(PARKING_LOT_NOT_CREATED);
            return;
        }
        //TODO: VALIDATION FOR DUPLICATE VEHICLE
        Optional<Integer> slotNum = parkingLot.getSlotNumberByRegistrationNumber(registrationNumber);
        if(slotNum.isPresent()){
            System.out.println(DUPLICATE_VEHICLE_MESSAGE);
            return;
        }

        try {
            Car car = new Car(registrationNumber, color);
            Ticket ticket = parkingLot.reserveSlot(car);
            System.out.println(String.format(PARKING_SLOT_ALLOCATED_MSG,ticket.getFloorNumber(), ticket.getSlotNumber()));
        } catch (IllegalArgumentException ex) {
            System.out.println("Bad input: " + ex.getMessage());
        } catch (ParkingLotFullException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void status() {
        if(!isParkingLotCreated()) {
            System.out.println(PARKING_LOT_NOT_CREATED);
            return;
        }

        System.out.println(FLOOR_NO+"    " +SLOT_NO + "    " + REGISTRATION_NO + "    " + Color);
        parkingLot.getOccupiedSlots().forEach(parkingSlot -> {
            System.out.println(
                    StringUtils.rightPadSpaces(Integer.toString(parkingSlot.getFloorNumber()), FLOOR_NO.length()) + "    "+
                    StringUtils.rightPadSpaces(Integer.toString(parkingSlot.getSlotNumber()), SLOT_NO.length()) + "    " +
                    StringUtils.rightPadSpaces(parkingSlot.getCar().getRegistrationNumber(), REGISTRATION_NO.length()) + "    " +
                    parkingSlot.getCar().getColor());
        });
    }


    private boolean isParkingLotCreated() {
        if(parkingLot == null) {
            return false;
        }
        return true;
    }

    public void leaveParkingSlot(int slotNum) {
        if(!isParkingLotCreated()) {
            System.out.println(PARKING_LOT_NOT_CREATED);
            return;
        }

        try {
            parkingLot.leaveSlot(slotNum);
            System.out.println(String.format(SLOT_IS_FREE, slotNum));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
