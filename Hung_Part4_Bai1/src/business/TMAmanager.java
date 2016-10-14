package business;

import common.Utils;
import data.FileHandlers;
import model.TMAEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by WataruS on 10/8/2016.
 */
public class TMAmanager {
    private List<TMAEmployee> TMAemployees;

    public List<TMAEmployee> getTMAemployees() {
        return TMAemployees;
    }

    public void setTMAemployees(List<TMAEmployee> TMAemployees) {
        this.TMAemployees = TMAemployees;
    }

    public void getTMAemployeeFromFile(String filePath){
        FileHandlers fp = new FileHandlers(filePath);
        List<String> fileContent = fp.readFile();
        if (fileContent.size() <= 0){
            System.out.println("There's nothing in " + filePath + " to import employee");
        } else {
            this.TMAemployees = new ArrayList<>();
            for(String line:fileContent){
                TMAEmployee emp = new TMAEmployee(line);
                this.TMAemployees.add(emp);
            }
        }

    }

    public void writeTMAemployeeToFile(String filePath, Boolean isAppend){
        FileHandlers fp = new FileHandlers(filePath);
        List<String> content = new ArrayList<>();
        for(TMAEmployee emp:TMAemployees){
            content.add(emp.toString());
        }

        fp.writeToFile(content,isAppend);

    }

    public void addNewEmployee(){
        TMAEmployee emp = new TMAEmployee();
        emp.createNewTMAemployee();
        this.TMAemployees.add(emp);

    }

    public void addNewEmployee(String employeDetails){
        TMAEmployee emp = new TMAEmployee(employeDetails);
        this.TMAemployees.add(emp);

    }

    public void deleteEmployeeByName(String name, Scanner sc){
        List<TMAEmployee> deleteEmployees = new ArrayList<TMAEmployee>();
        for (TMAEmployee emp:TMAemployees){
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {

                    System.out.println("Do you want to delete " + emp);
                    System.out.print("Press Y to delete, N to skip this employee: ");
                    String choice = Utils.validateInputString(sc);
                    if (choice.toLowerCase().equals("y")){
                        deleteEmployees.add(emp);
                    }
            }
        }

        for(TMAEmployee emp:deleteEmployees){
            TMAemployees.remove(emp);
        }
    }


    public static void storeToHashmap(List<TMAEmployee> list, HashMap hm) {

        for (TMAEmployee emp : list) {
            String name = emp.getName();
            if (hm.containsKey(name)) {
                putNewElementToHashMap(hm, name, emp, 0);
            } else {
                hm.put(name, emp);
            }
        }
    }

    public static void putNewElementToHashMap(HashMap hm, String key, TMAEmployee value, int index){
        String newKey = "";
        String oldKey = key.split(" ")[0];

        if (hm.containsKey(key)){
            index++;
            newKey = oldKey + " " + index;
            putNewElementToHashMap(hm, newKey,value, index);
        } else {
            hm.put(key, value);
        }
    }

    public static List<TMAEmployee> searchByName(TMAmanager tmaManager, String name){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp:tmaManager.getTMAemployees()){
            if (emp.getName().toLowerCase().contains(name.trim().toLowerCase())){
                result.add(emp);
            }
        }
        return result;
    }

    public static void modifyEmployeeInfo(TMAmanager tmaManager, String name, Scanner sc, String modifyInfo){
        List<TMAEmployee> searchReuslt = searchByName(tmaManager,name);
        if (searchReuslt.size() > 1) {
            for (TMAEmployee emp : tmaManager.getTMAemployees()) {
                if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("Do you want to modify information of " + emp);
                    System.out.print("Press Y to delete, N to skip this employee: ");
                    String choice = Utils.validateInputString(sc);
                    if (choice.toLowerCase().equals("y")) {
                        emp.modifyInfo(modifyInfo, sc);
                    }
                }
            }
        } else if (searchReuslt.size() == 1){
            searchReuslt.get(0).modifyInfo(modifyInfo, sc);
        } else {
            System.out.println("There's no employee with name " + name + ". Stopping modification process.");
        }

    }

    public List<TMAEmployee> searchByWorkingProject( String workingProject){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp:TMAemployees){
            if (emp.getWorkingProject().toLowerCase().trim().equals(workingProject.trim().toLowerCase())){
                result.add(emp);
            }
        }
        return result;
    }

    public List<TMAEmployee> searchByPosition( String position){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp:TMAemployees){
            if (emp.getPosition().toLowerCase().trim().equals(position.trim().toLowerCase())){
                result.add(emp);
            }
        }
        return result;
    }

    public List<TMAEmployee> searchByDateOfBirth(String dateOfBirth){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp: TMAemployees){
            if (emp.getBirthday ().trim().equals(dateOfBirth.trim())){
                result.add(emp);
            }
        }
        return result;
    }

    public List<TMAEmployee> searchByPhoneNumber( String phoneNumber){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp:TMAemployees){
            if (emp.getPhoneNumber().trim().equals(phoneNumber.trim())){
                result.add(emp);
            }
        }
        return result;
    }

    public List<TMAEmployee> searchByHometown( String hometown){
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp:TMAemployees){
            if (emp.getHomeTown().toLowerCase().trim().equals(hometown.trim().toLowerCase())){
                result.add(emp);
            }
        }
        return result;
    }

}
