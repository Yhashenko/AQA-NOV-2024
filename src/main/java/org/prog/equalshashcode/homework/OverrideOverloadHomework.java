package org.prog.equalshashcode.homework;

import static org.prog.equalshashcode.homework.AnimalClass.*;

/**
 * Write inheritance classes with depth of 4:
 * classA > classB > classC > classD
 *
 * Add a method to base class
 * Override that method in classB and classD slots
 *
 * Add method with overload to any class with at least 3 samples
 * method(a), method(a,b) method(a,b,c)
 */
public class OverrideOverloadHomework {
    // AnimalClass > WolfClass > GermanShepherdClass > PugClass
    public static void main(String[] args) {
        AnimalClass animalClass = new AnimalClass();
        WolfClass wolfClass = new WolfClass();
        GermanShepherdClass germanShepherdClassClass = new GermanShepherdClass();
        PugClass pugClass = new PugClass();

        animalClass.dailyTasks();
        wolfClass.dailyTasks();
        germanShepherdClassClass.dailyTasks();
        pugClass.dailyTasks();

        animalClass.tasks("Animal");
    }
}
