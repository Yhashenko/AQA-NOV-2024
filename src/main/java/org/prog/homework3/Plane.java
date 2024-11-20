package org.prog.homework3;

import java.util.stream.Stream;

//TODO: write class Plane with fields "flightId", "destination", "airlines"
//TODO: write hashCode and Equals (see Car)
//TODO: compare planes with null flightId and catch exception, in catch write "flight id is missing"
//TODO: in try-catch-finally add finally and print "works anyway"
public class Plane {
    public String flightId;
    public String destination;
    public String airlines;

    @Override
    public String toString() {
        return flightId + " flies to " + destination + " by " + airlines;
    }

    @Override
    public int hashCode() {

        return (flightId + destination + airlines).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plane) {
            Plane p = (Plane) obj;
            boolean planesAreTheSame = this.flightId.equals(p.flightId) &&
                    this.destination.equals(p.destination) && this.airlines.equals(p.airlines);
            return planesAreTheSame;
        }
        return false;
    }
}




