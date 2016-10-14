package utils;

/**
 * Created by WataruS on 10/8/2016.
 */
public class HashMapHandlers {
    public static void putNewElementToHashMap(HashMap hm, String key, String value){
        if (hm.containsKey(key)){
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

}
