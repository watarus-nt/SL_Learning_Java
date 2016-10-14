package executions;

import business.Hung_Part_5_Bai_1;
import business.Hung_Part_5_Bai_2;
import model.People;
import utils.FileHandlers;
import utils.HashMapHandlers;
import utils.Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tranmanhhung on 10/12/2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        FileHandlers fh = new FileHandlers("Bai5.txt");
        Scanner sc = new Scanner(System.in);

        String isOverwrite = "";
        if (fh.isFileExist()){
            System.out.print("Do you want to overwrite the existing content with new default content? (y/n)");
            isOverwrite = Utilities.validateInputString(sc);
            if (isOverwrite.equals("y")){
                Hung_Part_5_Bai_1.bai1(fh, false);
            } else {
                System.out.println("Using the existing content for searching");
            }
        } else {
            fh.createFile();
            Hung_Part_5_Bai_1.bai1(fh,false);
        }



        String isContinue = "";
        do{
            System.out.print("Input a number to search: ");
            String searchNumber = Utilities.validateInputPhoneNumber(sc);
            HashMap<String, People> hm = HashMapHandlers.getHashMapFromFile(fh.getFilePath().toString());
            People searchResult = Hung_Part_5_Bai_2.search(hm, searchNumber);

            if (searchResult == null){
                System.out.println("Not Found - There's no person who has phone number = " + searchNumber);
                //generate a new random name for search number
                String newName = Utilities.generateRandomName(5);
                System.out.println("Adding that number with a random name to data source");
                System.out.println("Adding " + searchNumber + "-" + newName + "to data source");
                fh.writeToFile(searchNumber + "-" + newName, true);
            } else {
                System.out.println("Found "+ searchResult);
            }






            System.out.println("Do you want to search another phone number? Press N to stop");
            System.out.print("Input your choice here: ");
            isContinue = Utilities.validateInputString(sc);
            System.out.println("----------------------------------------------------------------------------");

        } while (!isContinue.toLowerCase().equals("n"));

        sc.close();
//        fh.deleteFile();
    }
}
