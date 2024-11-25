package org.prog.collections;

//TODO: Write code where single car be owned by multiple unique owners
//TODO: some cars can have multiple owners
//TODO: print owner names for all owners that share cars

// > Jane : Car1, Car2, Car3
// > John : Car4
// > Bill: Car1, Car5
// > Sarah : Car4
// > ...
// > ...

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// >>>> Car1: Jane, Bill
// >>>> Car4: John, Sarah
    public class SharedCarOwnership {
        public static void main(String[] args) {
            Map<String, Set<String>> carOwners = new HashMap<>();

            addOwnerToCar(carOwners, "Tesla Model S", "Alex");
            addOwnerToCar(carOwners, "Tesla Model S", "Max");
            addOwnerToCar(carOwners, "Ford Mustang", "Julie");
            addOwnerToCar(carOwners, "Chevrolet Camaro", "Julie");
            addOwnerToCar(carOwners, "Chevrolet Camaro", "Max");
            addOwnerToCar(carOwners, "BMW X5", "Eve");

            displayCarOwners(carOwners);
            displaySharedCarOwners(carOwners);
        }

        public static void addOwnerToCar(Map<String, Set<String>> carOwners, String car, String owner) {
            carOwners.putIfAbsent(car, new HashSet<>());
            carOwners.get(car).add(owner);
        }

        public static void displayCarOwners(Map<String, Set<String>> carOwners) {
            System.out.println("Car ownership details:");
            for (Map.Entry<String, Set<String>> entry : carOwners.entrySet()) {
                System.out.println("Car: " + entry.getKey() + ", Owners: " + entry.getValue());
            }
        }

        public static void displaySharedCarOwners(Map<String, Set<String>> carOwners) {
            System.out.println("Owners who share cars:");
            Set<String> sharedOwners = new HashSet<>();

            for (Map.Entry<String, Set<String>> entry : carOwners.entrySet()) {
                Set<String> owners = entry.getValue();
                if (owners.size() > 1) {
                    sharedOwners.addAll(owners);
                }
            }

            System.out.println("Owners sharing cars: " + sharedOwners);
        }
    }


