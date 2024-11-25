package org.prog.poly.homework;

import org.prog.poly.Android;
import org.prog.poly.ApplePhones;
import org.prog.poly.ICellPhone;

/** TODO: HOMEWORK
 * Write interface for a cell phone which can (ICellPhone):
 * - call
 * - scan biometrics
 * - make photo
 *
 * Add Adnroid and Apple phones which implement this interface
 * Write method that will accept ICellPhone as parameter
 * And it will scan,make photo, call;
 */
public class PolyHomeWork {
    public static void main(String[] args) {
        Android android = new Android();
        ApplePhones applephones = new ApplePhones();

        parameter(android);
        parameter(applephones);
    }

    public static void parameter(ICellPhone iCellPhone) {
        iCellPhone.makeCalls();
        iCellPhone.scanBiometrics();
        iCellPhone.makePhoto();

    }
}

