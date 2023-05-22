package rozwiazania;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

public class Zadanie_7 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        JSONObject bodyRequestAddItem = new JSONObject();
        bodyRequestAddItem.put("product_id", 142);
        bodyRequestAddItem.put("quantity", 1);
        bodyRequestAddItem.put("return_cart", true);

        String endpointAddItem = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequestAddItem.toString(), endpointAddItem);

        // Ad 2
        String endpoint = "/cocart/v1/totals?html=true";
        Response response = serviceHelper.sendGetRequest(endpoint);

        // Ad 3
        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        String cartContentsTax = response.getBody().jsonPath().getString("cart_contents_tax");
        System.out.println(cartContentsTax);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        Double cartContentsTaxes = obj.getJSONObject("cart_contents_taxes").getDouble("1");
        System.out.println(cartContentsTaxes);

        String total = obj.getString("total");
        System.out.println(total);
    }
}
