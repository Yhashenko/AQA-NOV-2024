package org.prog.objects;

import org.prog.cars.Car;

public class ObjectsDemo {

    public static void main(String[] args) {
        Object o = new Object();
        Car car1 = new Car();
        Car car2 = new Car();

//        car1.color = "red";
//        car1.ownerName = "John";
//
//        car2.color = "red";
//        car2.ownerName = "John";

        try {
            System.out.println(car1.equals(car2));
            System.out.println(car1.hashCode());
            System.out.println(car2.hashCode());
        } catch (NullPointerException nullPointerException) {
            System.out.println("oops!");
        }

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }
}
