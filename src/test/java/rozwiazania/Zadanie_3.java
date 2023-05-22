package rozwiazania;

import org.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

public class Zadanie_3 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        JSONObject bodyRequestAddItem = new JSONObject();
        bodyRequestAddItem.put("product_id", 142);
        bodyRequestAddItem.put("quantity", 10);
        bodyRequestAddItem.put("return_cart", true);

        String endpointAddItem = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequestAddItem.toString(), endpointAddItem);

        // Ad 2 - Postman

        // Ad 3
        JSONObject bodyRequestUpdate = new JSONObject();
        bodyRequestUpdate.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequestUpdate.put("quantity", 2);
        bodyRequestUpdate.put("return_cart", true);

        String endpointUpdate = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequestUpdate.toString(), endpointUpdate);

    }
}
