package utils;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by tranmanhhung on 10/12/2016.
 */
public class Utilities {

    public static String generateRandomNumberWithInputLength(int length) {
        Random random = new Random();
        char[] digits = new char[length];

        for (int i = 0; i < length; i++) {
            int num = random.nextInt(10);
            digits[i] = (char) (num + '0');//ASCII code of number 0 is 48, this expression will return a number accroding to ASCII table
        }
        return (new String(digits));
    }

    public static String generateRandomName(int length) {
        char[] name = new char[length];
        name[0] = (char) (randomAlphabetCharacter() - 32);
        for (int i=1;i<length;i++){
            name[i] = randomAlphabetCharacter();
        }
        return (new String(name));
    }

    private static char randomAlphabetCharacter () {
        Random random = new Random();
        int num = random.nextInt(26);
        return (char) (num + 'a');
    }

    //this method will check whether user input anything before pressing enter
    public static String validateInputString(Scanner sc) {
        boolean isValid = false;
        String text = sc.nextLine();
        do {
            if ((text.trim().length()) > 0){
                isValid = true;
            }
            else {
                System.out.println("You've just inputted white spaces or just pressed Enter only.");
                System.out.print("Please input again: ");
                text = sc.nextLine();
            }
        }while (!isValid);
        return  text;
    }

    public static String validateInputPhoneNumber(Scanner sc){
        boolean isValid = false;
        String number = validateInputString(sc);
        do {
            if (((number.trim().length()) == 10) || ((number.trim().length()) == 11)){
                isValid = true;
            }
            else {
                System.out.println("Phone number should be 10 or 11 digits long.");
                System.out.print("Please input again: ");
                number = validateInputString(sc);
            }
        }while (!isValid);
        return  number;
    }


    public static Boolean validateString(String text) {
        return  (text.trim().length() > 0 );
    }

    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
