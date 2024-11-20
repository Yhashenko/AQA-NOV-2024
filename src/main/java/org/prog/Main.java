package org.prog;

import org.prog.cars.Car;

public class Main {

    public static void main(String[] args) {
        Car carRed = new Car();
        Car carGreen = new Car();
        Car carYellow = new Car();

        carRed.color = "red";
        carGreen.color = "green";
        carYellow.color = "yellow";

        System.out.println(carRed.hashCode());
        System.out.println(carGreen.hashCode());
        System.out.println(carYellow.hashCode());

//        carRed.goTo("Dnipro");
//        carGreen.goTo("Kyiv");
//        carYellow.goTo("Odessa");

//        System.out.println("Car #1 color is " + carRed.color);
//        System.out.println("Car #2 color is " + carGreen.color);
//
//        carGreen.color = "yellow";
//        System.out.println("Car #2 color is " + carGreen.color);
    }
}
