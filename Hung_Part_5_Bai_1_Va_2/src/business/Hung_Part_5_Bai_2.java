package business;

import utils.FileHandlers;
import utils.Utilities;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tranmanhhung on 10/12/2016.
 */
public class Hung_Part_5_Bai_2 {
    public static void bai2_useList(String searchText) {
        FileHandlers fh = new FileHandlers("Bai5.txt");
        List<String> content = fh.readFile();
        long startTime = System.currentTimeMillis();

        try {
            String searchResult = fh.search(content,searchText);
            if (! searchResult.equals("Not Found")) {
                System.out.println("Found " + searchResult.split("-")[1].trim() +" has phone number " + searchText);
            } else {
                String newName = Utilities.generateRandomName(5);
                System.out.println("Not Found  - Write \"" + searchText + " - " + newName + "\" to Bai5.txt");
                fh.writeToFile(searchText + " - " + newName ,true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds.");
    }

    public static void bai2_useHashMap(String searchText) {
        FileHandlers fh = new FileHandlers("Bai5.txt");
        HashMap<String, String> hm = fh.createHashMapFromFile();
        long startTime = System.currentTimeMillis();

        try {
            String searchResult = fh.search(hm,searchText);
            if (! searchResult.equals("Not Found")){
                System.out.println("Found " +searchResult + " has phone number " + searchText);
            } else {
                String newName = Utilities.generateRandomName(5);
                System.out.println("Not Found  - Write \"" + searchText + " - " + newName + "\" to Bai5.txt");
                fh.writeToFile(searchText + " - " + newName + "\n" ,true);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds.");
    }
}
