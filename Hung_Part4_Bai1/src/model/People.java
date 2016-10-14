package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by WataruS on 10/8/2016.
 */
public class People {
    private String name;
    private int age;
    private Date birthday;
    private String homeTown;
    private Number phoneNumber;
    private String occupation;
    private String workingCompany;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        birthDate.setTime(this.birthday);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }

        this.age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
    }

    public String getBirthday() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(birthday); //2014/08/06
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getPhoneNumber() {
        return "0" + this.phoneNumber.toString();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Long.parseLong(phoneNumber);
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkingCompany() {
        return workingCompany;
    }

    public void setWorkingCompany(String workingCompany) {
        this.workingCompany = workingCompany;
    }
}

