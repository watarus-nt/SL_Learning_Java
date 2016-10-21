package model;

import utils.Utilities;

/**
 * Created by WataruS on 10/20/2016.
 */
public class People {
    private  int index;
    private  String name;
    private  String phoneNumber;
    private String team;
    private String sex;
    private String description;

    public People(int index, String name, String phoneNumber, String team, String sex, String description){
        setIndex(index);
        setName(name);
        setPhoneNumber(phoneNumber);
        setTeam(team);
        setSex(sex);
        setDescription(description);
    }

    public People(int index, String name, String phoneNumber){
        setIndex(index);
        setName(name);
        setPhoneNumber(phoneNumber);
        setTeam(team);
        setDescription(description);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
