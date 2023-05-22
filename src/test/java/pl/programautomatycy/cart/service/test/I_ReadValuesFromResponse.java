package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.util.Map;

public class I_ReadValuesFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void readCalculateValuesJsonPath(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        Double subtotalTax = response.getBody().jsonPath().getDouble("subtotal_tax");
        System.out.println(subtotalTax);

        Object cartContentsTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        System.out.println(cartContentsTaxes);

        Map<String, Double> cartContentsTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentsTaxesMap.get("1"));
    }

    @Test
    public void readValuesAddItemJSONObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");
        System.out.println(key);

        Integer productId = obj.getInt("product_id");
        System.out.println(productId);

        String productName = obj.getString("product_name");
        System.out.println(productName);

        Double total = obj.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void readValuesAddItemJSONObjectByKey(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 138);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        Integer productId = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getInt("product_id");
        System.out.println(productId);

        String productPrice = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getString("product_price");
        System.out.println(productPrice);

        Double total = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void getCartContentsMap(){
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);

        Map<String, Object> products = response.getBody().jsonPath().get();

        for(Map.Entry<String, Object> product : products.entrySet()){
            System.out.println(product.getKey());

            Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_id"));
            System.out.println(values.get("quantity"));
            System.out.println(values.get("product_name"));

            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data");
            Map<String, Double> total = (Map<String, Double>) lineTaxData.get("total");
            System.out.println(total.get("1"));

            System.out.println("#######################");
        }
    }
}
