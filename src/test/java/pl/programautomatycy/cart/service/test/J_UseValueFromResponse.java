package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class J_UseValueFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void useResponseToUpdateItem() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response1 = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response1.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");

        JSONObject bodyRequest2 = new JSONObject();
        bodyRequest2.put("cart_item_key", key);
        bodyRequest2.put("quantity", 10);

        String endpoint2 = "/cocart/v1/item";
        Response response2 = serviceHelper.sendPostRequest(bodyRequest2.toString(), endpoint2);

        response2.getBody().prettyPrint();
    }
}
