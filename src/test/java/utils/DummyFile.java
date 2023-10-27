package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class DummyFile {
    public static void main(String[] args) {

        try {

            JSONParser parser = new JSONParser();
            JSONArray customerArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\json_file.json"));
            System.out.println(customerArray.get(0));
            for (Object o : customerArray) {
                JSONObject customerObject = (JSONObject) o;

                Integer customerId = (Integer) customerObject.get("customer_id");
                String name = (String) customerObject.get("name");

                System.out.println("Customer ID: " + customerId);
                System.out.println("Name: " + name);
            }
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }
    }
}
