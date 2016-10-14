package model;

import common.Constants;
import common.Utils;

import java.util.Scanner;

/**
 * Created by WataruS on 10/8/2016.
 */
public class TMAEmployee extends People{
    private String  workingProject;
    private String  position;

    public TMAEmployee(String employeeDetails){
        String[] employee = employeeDetails.split("-");
        if (employee.length == 6){
            setWorkingCompany("TMA");
            setOccupation("Software Engineer");
            setName(employee[0].trim());
            setWorkingProject(employee[1].trim());
            setPosition(employee[2].trim());
            setBirthday(employee[3].trim());
            setPhoneNumber(employee[4].trim());
            setHomeTown(employee[5].trim());
            setAge();
        }

    }

    public TMAEmployee(){

    }

    public void createNewTMAemployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee Name: ");
        setName(Utils.validateInputString(sc));
        System.out.print("Birthday (in \"dd/MM/yyy\" format): ");
        setBirthday(Utils.validateInputString(sc));
        System.out.print("Hometown: ");
        setHomeTown(Utils.validateInputString(sc));
        System.out.print("Phone Number: ");
        setPhoneNumber(Utils.validateInputPhoneNumber(sc));
        System.out.print("Working Project: ");
        setWorkingProject(Utils.validateInputString(sc));
        System.out.print("Position : ");
        setPosition(Utils.validateInputString(sc));
        setOccupation("Software Engineer");
        setWorkingCompany("TMA");
        setAge();
    }


    public String getWorkingProject() {
        return workingProject;
    }

    public void setWorkingProject(String workingProject) {
        this.workingProject = workingProject;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (Constants.isInPositionEnum(position)) {
            this.position = position;
        } else {
            this.position = Constants.Position.NOT_DEFINE.name();
        }
    }

    public String toString(){
        return super.getName() + " - " + super.getAge()  + " years old - "  + super.getWorkingCompany()
                + " - "  + this.getWorkingProject() + " - "  + this.getPosition() + " - "  + super.getBirthday()
                + " - "  + super.getPhoneNumber() + " - "  + super.getHomeTown();
    }

    public void modifyInfo(String attributeToModify, Scanner sc){
        switch (Integer.parseInt(attributeToModify)) {
            case 1:
                System.out.print("New name: ");
                String newName = Utils.validateInputString(sc);
                setName(newName);
                break;
            case 2:
                System.out.print("New working project: ");
                String newWorkingProject = Utils.validateInputString(sc);
                setWorkingProject(newWorkingProject);
                break;
            case 3:
                System.out.print("New Position: ");
                String newPosition = Utils.validateInputString(sc);
                setPosition(newPosition);
                break;
            case 4:
                System.out.print("New phone number: ");
                String newPhoneNumber = Utils.validateInputPhoneNumber(sc);
                setPhoneNumber(newPhoneNumber);
                break;
            case 5:
                System.out.print("New hometown: ");
                String newHometowm = Utils.validateInputString(sc);
                setHomeTown(newHometowm);
                break;
            case 6:
                System.out.print("New birthday: ");
                String newBirthday = Utils.validateInputString(sc);
                setBirthday(newBirthday);
                break;
            default:
                System.out.println("Your input number is not in support list.");
                break;
        }
    }


}
