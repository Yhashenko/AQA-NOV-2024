package org.prog.objects;

import org.prog.cars.Car;
import org.prog.homework3.Plane;

public class ObjectsDemo {

    public static void main(String[] args) {
        Object o = new Object();
        Plane plane1 = new Plane();
        Plane plane2 = new Plane();

      plane1.flightId = null;
      plane1.destination = "Paris";
      plane1.airlines = "S7 Airlines";

      plane2.flightId = null;
      plane2.destination = "Paris";
      plane2.airlines = "S7 Airlines";

        try {
            System.out.println(plane1.equals(plane2));
            System.out.println(plane1.hashCode());
            System.out.println(plane2.hashCode());
        } catch (NullPointerException nullPointerException) {
            System.out.println("flight id is missing");
        } finally {
            System.out.println("works anyway");

        }

        System.out.println(plane1.toString());
        System.out.println(plane2.toString());
    }
}
