package executions;

import business.Hung_Part_5_Bai_1;
import business.Hung_Part_5_Bai_2;
import model.People;
import utils.FileHandlers;
import utils.HashMapHandlers;
import utils.Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tranmanhhung on 10/12/2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        FileHandlers fh = new FileHandlers("Bai5.txt");
        Scanner sc = new Scanner(System.in);
        String isContinue = "";

        String isOverwrite = "";
        if (fh.isFileExist()) {
            System.out.print("Do you want to overwrite the existing content with new default content? (y/n)");
            isOverwrite = Utilities.validateInputString(sc);
            if (isOverwrite.equals("y")) {
                Hung_Part_5_Bai_1.bai1(fh, false);
            } else {
                System.out.println("Using the existing content for searching");
            }
        } else {
            System.out.println("Creating new Bai5.txt file with random content.");
            fh.createFile();
            Hung_Part_5_Bai_1.bai1(fh, false);
        }

        searchByPhoneNumber(fh, sc);

    }

    private static void searchByPhoneNumber(FileHandlers fh, Scanner sc) throws IOException {
        String isContinue = "";
        //Loading file content to a hashmap collection to search faster
        HashMap<String, People> hm = HashMapHandlers.getHashMapFromFile(fh.getFilePath().toString());
        //Loading file content to a List collection to keep the insertion orders
        List<People> peopleListFromFile = fh.getPeopleListFromFile();
        do {
            System.out.print("Input a number to search: ");
            String searchNumber = Utilities.validateInputPhoneNumber(sc);

            //calling search method
            People searchResult = Hung_Part_5_Bai_2.search(hm, searchNumber);

            if (searchResult == null) {
                System.out.println("Not Found - There's no person who has phone number = " + searchNumber);
                //generate a new random name for search number
                String newName = Utilities.generateRandomName(5);
                System.out.println("Adding that number with a random name to data source");
                System.out.println("Adding " + searchNumber + "-" + newName + " to data source");
                fh.writeToFile("\n" + searchNumber + "-" + newName, true);
            } else {
                System.out.println("Found " + searchResult);
                modifyNameByPhoneNUmber(hm, peopleListFromFile, searchResult, sc);
            }

            System.out.println("Do you want to search another phone number? Press N to stop");
            System.out.print("Input your choice here: ");
            isContinue = Utilities.validateInputString(sc);
            System.out.println("----------------------------------------------------------------------------");
        } while (!isContinue.toLowerCase().equals("n"));

        System.out.println("Updating data source file (Bai5.txt)...");
        //write the content of people list in memory back to data source file
        fh.writeListPeopleToFile(peopleListFromFile, false);
        System.out.println("Done!");

    }

    //Modify Name attribute of People object in hashmap and List
    private static void modifyNameByPhoneNUmber(HashMap<String, People> hm, List<People> peopleListFromFile, People people, Scanner sc) {
        System.out.print("Do you want to update contact name for this phone number? (y/n)");
        String answer = Utilities.validateInputString(sc);

        if (answer.toLowerCase().equals("y")){
            System.out.print("Input new contact name: ");
            String newName = Utilities.validateInputString(sc);
            people.setName(newName);
            hm.put(people.getPhoneNumber(), people);
            peopleListFromFile.set(people.getIndex(), people);
            System.out.println("Updated - " + people );
        }
    }
}
