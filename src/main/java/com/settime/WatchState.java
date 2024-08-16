package com.settime;


/**
 * Public class WatchState
 * Description: This class is used to represent the state of a simple watch.
 * @author Wyatt Fredrickson
 */
public class WatchState {
    // Constants for the states of the watch
    private static final int MEASURE_TIME = 1;
    private static final int SET_TIME = 2;
    private static final int DEAD_BATTERY = 3;
    // Variable to hold the current state of the watch
    private int currentState;

    
    /**
     * Constructor for the WatchState class
     */
    public WatchState() {
        this.currentState = MEASURE_TIME;
    }


    /**
     * Method to handle the left button being pressed
     */
    public void pressLeftButton() {
        if (currentState == SET_TIME) {
            currentState = MEASURE_TIME;
        }
    }


    /**
     * Method to handle both buttons being pressed
     */
    public void pressBothButtons() {
        if (currentState == MEASURE_TIME) {
            currentState = SET_TIME;
        } else if (currentState == SET_TIME) {
            currentState = MEASURE_TIME;
        }
    }


    /**
     * Method to handle the timeout
     */
    public void timeout() {
        if (currentState == MEASURE_TIME) {
            currentState = MEASURE_TIME;
        }
    }


    /**
     * Method to handle the battery being empty
     */
    public void batteryEmpty() {
        currentState = DEAD_BATTERY;
    }


    /**
     * Method to get the current state of the watch
     * @return the current state of the watch
     */
    public int getCurrentState() {
        return currentState;
    }
}