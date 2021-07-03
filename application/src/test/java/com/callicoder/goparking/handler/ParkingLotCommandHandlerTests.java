package com.callicoder.goparking.handler;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.callicoder.goparking.utils.MessageConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotCommandHandlerTests {

   /* private static PrintStream sysOut;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setupStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void resetStream() {
        outContent.reset();
    }

    @Test
    public void testCreateParkingLotOutput() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.createParkingLot(numFloors, 10);

        assertEquals(String.format("Created a parking lot with 10 slots\n"), outContent.toString());
        assertEquals(String.format(PARKING_LOT_CREATED_MSG, 10) + "\n", outContent.toString());
    }

    @Test
    public void testCreateMultipleParkingLotOutput() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.createParkingLot(numFloors, 10);
        parkingLotCommandHandler.createParkingLot(numFloors, 6);

        assertTrue(outContent.toString().endsWith(PARKING_LOT_ALREADY_CREATED + "\n"));
    }


    @Test
    public void testParkOutput() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.createParkingLot(numFloors, 6);
        parkingLotCommandHandler.park("KA-01-HH-3141", "Black");

        assertTrue(outContent.toString().endsWith("Allocated slot number: 1\n"));
        assertEquals(String.format(PARKING_LOT_CREATED_MSG, 6) + "\n" +
                String.format(PARKING_SLOT_ALLOCATED_MSG, 1) + "\n", outContent.toString());
    }

    @Test
    public void testParkWithNoParkingLotOutput() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.park("KA-01-HQ-4669", "White");
        assertTrue(outContent.toString().endsWith(PARKING_LOT_NOT_CREATED + "\n"));
    }


    @Test
    public void testStatusWithNoParkingLotOutput() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.status();
        assertTrue(outContent.toString().endsWith(PARKING_LOT_NOT_CREATED + "\n"));
    }
    @Test
    public void testParkDuplicateVehicle() {
        ParkingLotCommandHandler parkingLotCommandHandler = new ParkingLotCommandHandler();
        parkingLotCommandHandler.createParkingLot(numFloors, 6);
        //parkingLotCommandHandler.createParkingLot(6);
        assertFalse(outContent.toString().endsWith(PARKING_LOT_ALREADY_CREATED + "\n"));
        parkingLotCommandHandler.park("KA-01-HH-3141", "Black");

        assertTrue(outContent.toString().endsWith("Allocated slot number: 1\n"));
        parkingLotCommandHandler.park("KA-01-HH-3141", "White");
        assertTrue(outContent.toString().endsWith(DUPLICATE_VEHICLE_MESSAGE+"\n"));
    }
    @AfterAll
    public static void revertStreams() {
        System.setOut(sysOut);
    }*/
}
