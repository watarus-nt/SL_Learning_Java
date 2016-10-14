package data;

import business.TMAmanager;
import model.TMAEmployee;

import java.util.HashMap;

/**
 * Created by WataruS on 10/8/2016.
 */
public class HashMapHandlers {


    public static List<TMAEmployee> getHashMapElements(HashMap hm) {
        /* Display content using Iterator*/
//        System.out.println("There're " + hm.size() + " elements in HashMap");
        List<TMAEmployee> result = new ArrayList<TMAEmployee>();
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
            result.add((TMAEmployee) mentry.getValue());
        }
        return result;
    }

    public static List<TMAEmployee> searchEmployee(HashMap hm, String searchText){
        List<TMAEmployee> employees = getHashMapElements(hm);
        List<TMAEmployee> searchResult = new ArrayList<TMAEmployee>();
        for(TMAEmployee emp: employees){
            if(emp.toString().toLowerCase().contains(searchText.toLowerCase())){
                searchResult.add(emp);
            }
        }
        return searchResult;
    }

    public static void storeToHashmap(TMAmanager tmaManager, HashMap hm) {

        for (TMAEmployee emp : tmaManager.getTMAemployees()) {
            String name = emp.getName().split(" ")[0];
            if (hm.containsKey(name)) {
                putNewElementToHashMap(hm, name, emp, 0);
            } else {
                hm.put(name, emp);
            }
        }
    }

    //when calling this method, always put index=0
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

    //Key should be first name only
    public static void deleteElementFromHashMap(HashMap hm, String key, Scanner sc){
        if (!hm.containsKey(key)){
            deleteElementFromHashMap(hm, key, sc);
        } else {
            hm.remove(hm.get(key));
        }
    }

    public static HashMap<String, TMAEmployee>  addEmployeeToHashMap(HashMap<String, TMAEmployee> hm, TMAEmployee employee){
        TMAEmployee emp = new TMAEmployee();
        emp.createNewTMAemployee();
        putNewElementToHashMap(hm, emp.getName().split(" ")[0],emp, 0);
        return hm;
    }



}
