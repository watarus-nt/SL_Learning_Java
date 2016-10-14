package model;

import utils.Utilities;

/**
 * Created by WataruS on 10/13/2016.
 */
public class People {
    private static int index;
    private static String name;
    private static String phoneNumber;

    public People(int index, String name, String phoneNumber){
        setIndex(index);
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        People.index = index;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        People.name = name;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        if (Utilities.isNumber(phoneNumber) && (phoneNumber.length()== 10)){
            People.phoneNumber = phoneNumber;
        } else {
            People.phoneNumber = "NOT_DEFINE";
        }
    }
}
