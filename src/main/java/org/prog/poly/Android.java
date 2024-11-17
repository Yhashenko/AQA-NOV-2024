package org.prog.poly;

public class Android implements ICellPhone{
    @Override
    public void makeCalls() {
        System.out.println("Android makes calls");
    }



    @Override
    public void scanBiometrics() {
        System.out.println("Android scans biometrics");
    }

    @Override
    public void makePhoto() {
        System.out.println("Android makes photo");
    }
}
