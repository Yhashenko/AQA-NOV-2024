package org.prog.poly;

public class ApplePhones implements ICellPhone{
    @Override
    public void makeCalls() {
        System.out.println("ApplePhones make calls");
    }

    @Override
    public void scanBiometrics() {
        System.out.println("ApplePhones scan biometrics");
    }

    @Override
    public void makePhoto() {
        System.out.println("ApplePhones make photo");
    }
}
