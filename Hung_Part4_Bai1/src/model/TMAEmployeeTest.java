package model;

import java.util.*;

/**
 * Created by WataruS on 10/8/2016.
 */
public class TMAEmployeeTest {
    public static void main(String args[]){
       HashMap hm = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        String exit = "";
        String key = "hung";
        String value = "bac";
        do{


/*            if (hm.containsKey(key)){
                doesHashMapContainKey(hm, key, value, 1);
            }else {
                hm.put(key, value);
            }*/

            putNewElementToHashMap(hm, key, value, 1);
            System.out.print("continue? Press # to stop: ");
            exit = sc.nextLine();
        }while (!exit.equals("#"));

     /* Display content using Iterator*/
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

    }

    public static void doesHashMapContainKey(HashMap hm, String key, String value, int index){
        String newKey = key + " " + index;
        if (hm.containsKey(newKey)){
            index++;
            newKey = key + " " + index;
            doesHashMapContainKey(hm, newKey,value, index);
        } else {
            hm.put((key + " " + index), value);
        }
    }

    //when calling this method, always put index=0
    public static void putNewElementToHashMap(HashMap hm, String key, String value, int index){
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
}
