package com.settime;
import org.junit.jupiter.api.BeforeEach; // import the BeforeEach annotation from the JUnit package
import org.junit.jupiter.api.Test; // import the Test class from the JUnit package
import static org.junit.jupiter.api.Assertions.*; // import all static methods from the Assertions class

/**
 * Unit test for simple WatchState.
 * This class will test the WatchState class
 */
class WatchStateTest {
    private WatchState watchState; // Declare a WatchState object


    /**
     * This method will run before each test
     * It will create a new WatchState object
     */
    @BeforeEach // This method will run before each test
    public void setUp() {
        watchState = new WatchState(); // Create a new WatchState object
    }


    /**
     * Test the initial state of the watch
     * This test will test the initial state of the watch
     */
    @Test
    void testInitialState() {
        // Check that the initial state of the watch is MEASURE_TIME
        assertEquals(1, watchState.getCurrentState()); 
    }


    /**
     * Test the press left button method
     * This test will test the press left button method
     */
    @Test   
    void testPressLeftButtonMeasureTime() {
        watchState.pressLeftButton(); // Press the left button
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the press both buttons method
     * This test will test the press both buttons method
     */
    @Test
    void testPressBothButtonsMeasureTime() {
        watchState.pressBothButtons(); // Press both buttons
        assertEquals(2, watchState.getCurrentState()); // Check that the state of the watch is SET_TIME
    }


    /**
     * Test the press both buttons method twice
     * This test will test the press both buttons method twice
     */
    @Test
    void testPressBothButtonsSetTime() {
        watchState.pressBothButtons(); // Press both buttons
        watchState.pressBothButtons(); // Press both buttons
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the timeout method
     * This test will test the timeout method
     */
    @Test
    void testTimeoutMeasureTime() {
        watchState.timeout(); // Call the timeout method
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the press left button method in the set time state
     * This test will test the press left button method in the set time state
     */
    @Test
    void testPressLeftButtonSetTime() {
        watchState.pressBothButtons(); // Press both buttons
        watchState.pressLeftButton(); // Press the left button
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the battery empty method in the set time state
     * This test will test the battery empty method in the set time state
     */
    @Test
    void testBatteryEmpty() {
        watchState.batteryEmpty(); // Call the batteryEmpty method
        assertEquals(3, watchState.getCurrentState()); // Check that the state of the watch is DEAD_BATTERY
    }


    /**
     * Test the repeated press both buttons
     * This test will test the repeated press both buttons
     */
    @Test
    void testRepeatedPressBothButtons() {
        watchState.pressBothButtons(); // Press both buttons
        watchState.pressBothButtons(); // Press both buttons
        watchState.pressBothButtons(); // Press both buttons
        watchState.pressBothButtons(); // Press both buttons
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the repeated press left button
     * This test will test the repeated press left button
     */
    @Test
    void testRepeatedPressLeftButton() {
        watchState.pressLeftButton(); // Press the left button
        watchState.pressLeftButton(); // Press the left button
        assertEquals(1, watchState.getCurrentState()); // Check that the state of the watch is MEASURE_TIME
    }


    /**
     * Test the entire watch state path
     * This test will test the entire path of the watch state
     */
    @Test
    void testTheEntireWatchStatePath() {
        watchState.pressBothButtons();
        assertEquals(2, watchState.getCurrentState());
        watchState.pressBothButtons();
        assertEquals(1, watchState.getCurrentState());
        watchState.pressLeftButton();
        assertEquals(1, watchState.getCurrentState());
        watchState.timeout();
        assertEquals(1, watchState.getCurrentState());
        watchState.batteryEmpty();
        assertEquals(3, watchState.getCurrentState());
    }


    /**
     * Test the watch state actions in the dead battery state
     * This test will test the watch state actions in the dead battery state
     */
    @Test
    void testWatchStateActionsInDeadBattery() {
        watchState.batteryEmpty();
        watchState.pressBothButtons();
        assertEquals(3, watchState.getCurrentState());
        watchState.pressLeftButton();
        assertEquals(3, watchState.getCurrentState());
        watchState.timeout();
        assertEquals(3, watchState.getCurrentState());
    }
}