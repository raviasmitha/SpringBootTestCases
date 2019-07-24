package com.stackroute.SpringBootTask.exceptions;

public class TrackNotFoundException extends Exception {
    public TrackNotFoundException(String s)
    {
        // Call constructor of parent Exception
        super(s);

    }
}
