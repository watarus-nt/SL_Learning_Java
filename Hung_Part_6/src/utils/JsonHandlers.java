package utils;

import model.People;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by WataruS on 10/20/2016.
 */
public class JsonHandlers {
    private JSONObject obj;

    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }

    public JsonHandlers(){
        this.obj = new JSONObject();
    }

    public static void main(String[] args) throws IOException {


        JsonHandlers jh = new JsonHandlers();
        jh.addNewPerson("Phu", "securelogix", "0912345678", "description\",\"handsome, baby, cute");
        jh.addNewPerson("Hung", "securelogix", "0938297100", "description\",\"handsome, baby, cute");

        jh.convertPeopleObjectToJsonObject(new People(3,"Watarus", "0938297100", "securelogix",
                                                      "description\",\"handsome, baby, cute"));
        jh.writeJsonObjectToFile();


    }

    public JSONObject convertPeopleObjectToJsonObject(People people){
        return addNewPerson(people.getName(), people.getTeam(), people.getPhoneNumber(), people.getDescription());
    }

    public JSONObject addNewPerson( String name, String team, String phone, String description){
        JSONArray personDetails = addPersonDetails(team, phone, description);
        getObj().put(name, personDetails);
        return obj;
    }

    public JSONArray addPersonDetails(String team, String phone, String description){
        JSONArray jsonArray = new JSONArray();
        JSONObject details = new JSONObject();
        details.put("team", team);
        details.put("phone", phone);
        details.put("description", description);
        jsonArray.add(details);
        return jsonArray;
    }

    public void writeJsonObjectToFile() throws IOException {
        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("json-data-source.txt")) {
            file.write(getObj().toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + getObj());
        }
    }
}
