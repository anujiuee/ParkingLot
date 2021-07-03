package com.callicoder.goparking.exceptions;

public class SlotAlredayEmptyException extends RuntimeException{

    private Integer slotNumber;

    public SlotAlredayEmptyException(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String getMessage() {
        return "Slot number " + slotNumber + " alreday empty";
    }
}
