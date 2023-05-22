package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.deserializing.*;

import java.util.Map;

public class L_Deserializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemResponseDeserializing() throws ParseException {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);


        //inny sposób pobrania body z responsu i sformatowania go na json
        //JSONObject json = new JSONObject(response.getBody().asString());
        JSONObject json = new JSONObject(response.asString());
        String jj = json.toString();
        System.out.println("response as string from json:" + jj);
        System.out.println("Product name from json:" + json.get("product_name"));
        json.put("nowy_arg1", "val_nowy_arg_1");
        System.out.println("nowy_arg_1 from json:" + json.get("nowy_arg1"));

        //jeszcze inna deserializacja
        AddItemResponse response1 = response.body().as(AddItemResponse.class);
        response1.getLineTaxData().getTotal().getTotal1();
        response1.getLineTaxData().getSubtotal().getSubtotal1();

        //poprawna deserializacja
        AddItemResponse responseBody = response.as(AddItemResponse.class);

        System.out.println(responseBody.getKey());
        System.out.println(responseBody.getQuantity());
        System.out.println(responseBody.getProductName());
        System.out.println(responseBody.getProductPrice());

//        Map<String, String> total = (Map<String, String>) responseBody.getLineTaxData().getTotal();
//        Object tot = total.get("1");
//        System.out.println(tot.toString());
        System.out.println(responseBody.getLineTaxData().getTotal().getTotal1());
    }
}
