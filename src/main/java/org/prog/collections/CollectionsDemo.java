package org.prog.collections;

//TODO:
// - each car can have several owners
// - owners can have several cars
// - list cars belonging to specific owner

import java.util.*;

public class CollectionsDemo {

    //TODO: Homework 1: add owners list ad parameter for addCarToCompany;
    //TODO*: Do only if you want! Make owners random! WARNING: make list of owners to pick from

    public static void main(String[] args) {
        Map<Car, List<String>> carsAndOwners = new HashMap<>();
        List<String> availableOwners = Arrays.asList("John", "Jane", "Denis", "Molly", "Charlie");
        List<String> availableBrands = Arrays.asList("Mazda", "Tesla", "BMW", "Suzuki", "Hyundai");

        addCarToCompany(carsAndOwners, "black", availableOwners, availableBrands);
        addCarToCompany(carsAndOwners, "white", availableOwners, availableBrands);
        addCarToCompany(carsAndOwners, "red", availableOwners, availableBrands);
        addCarToCompany(carsAndOwners, "blue", availableOwners, availableBrands);

        for (Map.Entry<Car, List<String>> entry : carsAndOwners.entrySet()) {
            Car car = entry.getKey();
            List<String> owners = entry.getValue();
            System.out.println("Car: " + availableBrands + " is owned by: " + owners);
        }
    }


    public static void addCarToCompany(Map<Car, List<String>> carsAndOwners, String color, List<String> availableOwners, List<String> availableBrands) {

        Car car = new Car();
        car.setColor(color);


        Random rand = new Random();
        int numOwners = rand.nextInt(3) + 1;  // Random number between 1 and 3 owners
        Set<String> randomOwners = new HashSet<>();


        while (randomOwners.size() < numOwners) {
            randomOwners.add(availableOwners.get(rand.nextInt(availableOwners.size())));
        }


        carsAndOwners.put(car, new ArrayList<>(randomOwners));
    }


    public static class Car {
        private String color;


        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Car{color='" + color + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(color, car.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color);
        }
    }
}