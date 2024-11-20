package org.prog.equalshashcode.homework;

public class AnimalClass {



    public void dailyTasks() {
        System.out.println("Runs all day");

    }

    public void tasks(String action) {
        tasks(action, "at 5 a.m.");
    }

    public void tasks(String action, String when) {
        tasks(action, when,  "somewhere");}

    public void tasks(String action, String when, String where) {
        System.out.println(action + " wakes up " + when + " in the forest " + " and goes hunting ");
    }
    String someString() {
        return "abc";
    }
}
