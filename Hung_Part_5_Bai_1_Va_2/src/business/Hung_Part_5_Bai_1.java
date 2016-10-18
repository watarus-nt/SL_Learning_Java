package business;

import utils.FileHandlers;
import utils.HashMapHandlers;
import utils.Utilities;

import java.io.IOException;
import java.util.HashMap;

public class Hung_Part_5_Bai_1 {

    public static void bai1(FileHandlers fh, Boolean isAppend) throws IOException {
        // write your code here
        HashMap<String, String> hm = new HashMap<String, String>();

        for (int i = 0; i < 100000; i++) {
            String key = "09" + Utilities.generateRandomNumberWithInputLength(8);
            String value = Utilities.generateRandomName(5);//Value is a alphabet string with 5 characters
            HashMapHandlers.putNewElementToHashMap(hm, key, value);
        }

        HashMapHandlers.writeHashMapToFile(hm, fh.getFilePath().toString(), isAppend);

    }
}
