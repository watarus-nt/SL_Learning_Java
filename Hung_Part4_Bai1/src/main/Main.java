package main;

import business.TMAmanager;
import common.Utils;
import data.FileHandlers;
import data.HashMapHandlers;
import model.TMAEmployee;

public class Main {

    public static void main(String[] args) {
        TMAmanager tmaManager = new TMAmanager();
        HashMap hm = new HashMap<String, TMAEmployee>();
        Scanner sc = new Scanner(System.in);
        String isContinue = "";

        do {

            System.out.println("1. Store employees to HashMap and print that Hashmap");
            System.out.println("2. Search Employee From HashMap");
            System.out.println("3. Delete Existing Employee ");
            System.out.println("4. Add New Employee then store to HashMap");
            System.out.println("5. Modify Employee Information");


            String choice;
            do {
                System.out.print("Input your choice: ");
                //assign user input to input variable after validating
                choice = Utils.validateInputString(sc);

                if (!Utils.isNumber(choice)) {
                    System.out.println("Your input is not valid one. Please input again.");
                } else
                    break;
            } while (true);

            switch (Integer.parseInt(choice)) {
                case 1:
                    tmaManager.setTMAemployees( new ArrayList<>());
                    tmaManager.addNewEmployee("Hung Tran Manh - SecureLogix - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Hung Tran Manh - SMS - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Hung Tran Manh - PCRF - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Hung Tran Manh - Globe - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Hung Tran Manh - Telstra - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Hung Tran Manh - Crammer - SENIOR_ENGINEER - 06/02/1990 - 0123456789 - Nha Trang");
                    tmaManager.addNewEmployee("Danh Ho Cong- SecureLogix - SENIOR_ENGINEER - 04/02/1990 - 8452107963 - Binh Thuan");
                    tmaManager.addNewEmployee("Danh Ho Cong- PMO - SENIOR_ENGINEER - 04/02/1990 - 8452107963 - Binh Thuan");
                    tmaManager.addNewEmployee("Danh Ho Cong- EE - SENIOR_ENGINEER - 04/02/1990 - 8452107963 - Binh Thuan");
                    tmaManager.addNewEmployee("Phu Nguyen Thai - SecureLogix - CONSULTANT - 16/12/1988 - 1478520369 - Da Lat");
                    tmaManager.addNewEmployee("Phu Nguyen Thai - Acatel - CONSULTANT - 16/12/1988 - 1478520369 - Da Lat");
                    tmaManager.addNewEmployee("Chien Nguyen Huu - SecureLogix - SENIOR_ENGINEER - 01/01/1989 - 8523697410 - Dak Lak");

                    showEmployeeList(tmaManager);
                    HashMapHandlers.storeToHashmap(tmaManager, hm);
                    printHashMap(hm);
                    tmaManager.setTMAemployees(null);
                    break;
                case 2:
                    initDefault(tmaManager, "SecureLogix.txt", hm);
                    searchEmploye(hm, sc);
                    break;
                case 3:
                    initDefault(tmaManager, "SecureLogix.txt", hm);
                    deleteEmployee(tmaManager, sc);
                    System.out.println("List of employee after deleting: ");
                    for (TMAEmployee emp : tmaManager.getTMAemployees()) {
                        System.out.println(emp);
                    }
                    break;
                case 4:
                    initDefault(tmaManager, "SecureLogix.txt", hm);
                    addNewEmployee(tmaManager, sc);

                    break;
                case 5:
                    initDefault(tmaManager, "SecureLogix.txt", hm);

                    System.out.print("Input employee's name to modify: ");
                    String modifyEmployeeName = Utils.validateInputString(sc);
                    modifyEmployeeInformation(tmaManager, modifyEmployeeName, sc);
                    showEmployeeList(tmaManager);
                    break;

                default:
                    System.out.println("Your input number is not in above list.");
                    break;
            }


            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println("Do you want to continue? Press N to stop, other to continue...");
            System.out.print("Please give your answer: ");
            //assign user input to input variable after validating
            isContinue = Utils.validateInputString(sc);
        } while (!(isContinue.toLowerCase().equals("n")));

        sc.close();
        System.out.println("Bye!!!");

    }

    public static void initDefault(TMAmanager tmaManager, String filePath, HashMap hm) {
        //Initial default data
        FileHandlers fp = new FileHandlers(filePath);
        fp.init();
        tmaManager.getTMAemployeeFromFile(filePath);
        HashMapHandlers.storeToHashmap(tmaManager, hm);

        showEmployeeList(tmaManager);

    }

    public static void showEmployeeList(TMAmanager tmaManager){
        System.out.println("----------------------Current Employees list----------------------");
        int i = 1;
        for (TMAEmployee emp:tmaManager.getTMAemployees()){
            System.out.println(i + ". " + emp);
            i++;
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void searchByAttribute(TMAmanager tmaManager, String filePath, Scanner sc) {

        List<TMAEmployee> searchResult = new ArrayList<TMAEmployee>();

        System.out.println("Select one of below numbers to search: ");
        System.out.println("1. Search By Name ");
        System.out.println("2. Search By Working Project ");
        System.out.println("3. Search By Position ");
        System.out.println("4. Search By Date Of Birth ");
        System.out.println("5. Search By Phone Number ");
        System.out.println("6. Search By Hometown ");

        String choice;
        do {
            System.out.print("Input your choice: ");
            //assign user input to input variable after validating
            choice = Utils.validateInputString(sc);

            if (!Utils.isNumber(choice)) {
                System.out.println("Your input is not valid one. Please input again.");
            } else
                break;
        } while (true);

        System.out.print("Input search text: ");
        String text = Utils.validateInputString(sc);
        switch (Integer.parseInt(choice)) {
            case 1:
                searchResult = tmaManager.searchByName(tmaManager,text);
                break;
            case 2:
                searchResult = tmaManager.searchByWorkingProject(text);
                break;
            case 3:
                searchResult = tmaManager.searchByPosition(text);
                break;
            case 4:
                searchResult = tmaManager.searchByDateOfBirth(text);
                break;
            case 5:
                searchResult = tmaManager.searchByPhoneNumber(text);
                break;
            case 6:
                searchResult = tmaManager.searchByHometown(text);
                break;
            default:
                System.out.println("Your input number isn't in the support list.");
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Found " + searchResult.size() + " record(s)");
        if (searchResult.size() > 0) {
//            storeToHashmap(searchResult, hm);
            System.out.println("Search result is showed below: ");
            for (TMAEmployee emp : searchResult) {
                System.out.println(emp);
            }
        }
    }

    public static void searchEmploye(HashMap hm, Scanner sc){
        System.out.print("Input a string to search for employ: ");
        String text = Utils.validateInputString(sc);
        List<TMAEmployee> searchResult = HashMapHandlers.searchEmployee(hm, text);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Found " + searchResult.size() + " record(s)");
        if (searchResult.size() > 0) {
//            storeToHashmap(searchResult, hm);
            System.out.println("Search result is showed below: ");
            for (TMAEmployee emp : searchResult) {
                System.out.println(emp);
            }
        }

    }

    public static void printHashMap(HashMap hm) {
        /* Display content using Iterator*/
        System.out.println("There're " + hm.size() + " elements in HashMap");
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
    }



    public static void deleteEmployee(TMAmanager tmaManager, Scanner sc) {
        System.out.print("Input employee name to delete: ");
        String name = Utils.validateInputString(sc);
        tmaManager.deleteEmployeeByName(name, sc);

    }

    public static void deleteEmployee(HashMap<String, TMAEmployee> hm, Scanner sc) {
        System.out.print("Input employee name to delete: ");
        String name = Utils.validateInputString(sc).split(" ")[0];
        HashMapHandlers.deleteElementFromHashMap(hm, name, sc);

    }

    public static void addNewEmployee(TMAmanager tmaManager, Scanner sc) {
        String choice = "";
        do {
            tmaManager.addNewEmployee();
            System.out.print("Press # to stop adding new employee: ");
            choice = Utils.validateInputString(sc);
        } while (!choice.trim().equals("#"));
    }

    public static void modifyEmployeeInformation(TMAmanager tmaManager, String name, Scanner sc){
        System.out.println("Which information you want to modify?");
        System.out.println("1. Modify name");
        System.out.println("2. Modify working project");
        System.out.println("3. Modify position");
        System.out.println("4. Modify phone number");
        System.out.println("5. Modify hometown");
        System.out.println("6. Modify birthday");
        System.out.print("Input a number: ");
        String choice = Utils.validateInputString(sc);
        tmaManager.modifyEmployeeInfo(tmaManager, name, sc, choice);
    }
}
