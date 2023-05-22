package utils;

import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonRequestBodyHelper {
    public static JSONObject getJsonFromFile(String jsonFileName, String testDataKey) {
        JSONObject bodyRequest = new JSONObject();
        try {
            InputStream is = new FileInputStream("src/test/resources/testData/" + jsonFileName + ".json");
            JsonPath jsonPath = JsonPath.from(is);
            bodyRequest.putAll(jsonPath.get(testDataKey));
        } catch (IOException e) {
            System.out.println("File not found " + e);
        }
        return bodyRequest;
    }
}
