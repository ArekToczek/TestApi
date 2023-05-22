package rozwiazania;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.deserializing.CalculateResponse;

public class Zadanie_9 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        // Ad 2
        CalculateResponse responseBody = response.as(CalculateResponse.class);

        // Ad 3
        System.out.println(responseBody.getSubtotal());
        System.out.println(responseBody.getSubtotalTax());
        System.out.println(responseBody.getCartContentsTaxes().getCartContentsTaxes1());
        System.out.println(responseBody.getTotal());
        System.out.println(responseBody.getTotalTax());
    }
}
