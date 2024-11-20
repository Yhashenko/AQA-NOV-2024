package org.prog.objects;

import org.prog.cars.Car;

public class ObjectsAndPrimitivesDemo {

    /**
     * ###################################
     * ########[car1.color = 'black'; car1.owner = 'John']@Car##################
     * ########[car2.color = 'black'; car2.owner = 'John']@Car##################
     * ###################################
     * @param args
     */

    public static void main(String[] args) {
        int i = 10;

        String s1 = null;
        String s2 = "";
        String s3 = "abc";

        Car car1 = new Car();
        Car car2 = new Car();
        paintCar(car1);
        paintCar(car2);

//        primitive(i);
//        System.out.println(">>>>>>> " + i);

        System.out.println(car1.color);
    }

    public static void primitive(int i) {
        System.out.println(i);
        i = 1000000;
        System.out.println(i);
    }

    public static void paintCar(Car car) {
        car.color = "black";
    }
}
