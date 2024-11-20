package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {

    public static void main(String[] args) {
        smth1();
        System.out.println("test");
    }

    public static void smth1() {
        try {
            smth2();
        } catch (Exception e){

        }
    }

    public static void smth2() {
        try {
            smth3();
        } catch (ArithmeticException arithmeticException) {
            System.out.println("arithmeticException");
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("index error!");
        } catch (NullPointerException npe) {
            System.out.println("NPE!");
        } catch (RuntimeException runtimeException) {
            System.out.println("RTE");
        } catch (IOException ioException) {
            System.out.println("I/O exception!");
        } catch (Exception e) {
            System.out.println("Bigger Exception!");
        } catch (Throwable throwable) {
            System.out.println("Something went VERY WRONG");
        }
    }

    public static void smth3() throws FileNotFoundException {
        smth4();
    }

    public static void smth4() throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File("a"));
    }
}
