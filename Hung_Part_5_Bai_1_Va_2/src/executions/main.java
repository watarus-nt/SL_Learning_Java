package executions;

import business.Hung_Part_5_Bai_1;
import business.Hung_Part_5_Bai_2;
import utils.FileHandlers;
import utils.Utilities;

import java.util.Scanner;

/**
 * Created by tranmanhhung on 10/12/2016.
 */
public class main {
    public static void main(String[] args) {
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
            Hung_Part_5_Bai_2.bai2_useHashMap(searchNumber);

            System.out.println("Do you want to search another phone number? Press N to stop");
            System.out.print("Input your choice here: ");
            isContinue = Utilities.validateInputString(sc);

        } while (!isContinue.toLowerCase().equals("n"));

        sc.close();
//        fh.deleteFile();
    }
}
