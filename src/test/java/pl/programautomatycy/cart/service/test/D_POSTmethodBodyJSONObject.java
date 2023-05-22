package pl.programautomatycy.cart.service.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class D_POSTmethodBodyJSONObject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 10);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void calculateWithBodyJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }
}
