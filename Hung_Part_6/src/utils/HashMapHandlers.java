package utils;

import model.People;

import java.io.*;
import java.util.*;

/**
 * Created by WataruS on 10/8/2016.
 */
public class HashMapHandlers {
    public static void putNewElementToHashMap(HashMap hm, String key, String value) {
        if (hm.containsKey(key)) {
            String newKey = "09" + Utilities.generateRandomNumberWithInputLength(8);
            putNewElementToHashMap(hm, newKey, value);
        } else {
            hm.put(key, value);
        }
    }

    public static List<String> getHashMapElements(HashMap hm) {
        List<String> content = new ArrayList<String>();
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            String line = mentry.getKey() + " - " + mentry.getValue();
            content.add(line);
        }
        return content;
    }

    public static void writeHashMapToFile(HashMap<String, String> hm, String filePath, Boolean isAppend) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,isAppend));
        for(String p:hm.keySet())
        {
            bw.write(p + "-" + hm.get(p));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static HashMap<String, People> getHashMapFromFile(String filePath) throws IOException {
        HashMap<String, People> hm = new HashMap<String, People>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        String line = "";
        int index = 0;
        while ((line = br.readLine()) != null) {
            String[] info = line.split("-");
            People people = new People(index, info[1], info[0]);
            hm.put(info[0], people);
            index++;
        }
        br.close();
        return hm;
    }
}
