package model;

import utils.Utilities;

/**
 * Created by WataruS on 10/13/2016.
 */
public class People {
    private  int index;
    private  String name;
    private  String phoneNumber;

    public People(int index, String name, String phoneNumber){
        setIndex(index);
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public  void setPhoneNumber(String phoneNumber) {
        if (Utilities.isNumber(phoneNumber) && (phoneNumber.length()== 10)){
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "NOT_DEFINE";
        }
    }

    @Override
    public String toString(){

        return "Name: " + this.name + " - Phone Number: " + this.phoneNumber + " - Index: " + getIndex();
    }


}
