package rozwiazania;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

public class Zadanie_6 {

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

        // Ad 2
        String endpointGetCart = "/cocart/v1/get-cart";
        Response responseGetCart = serviceHelper.sendGetRequest(endpointGetCart);
        responseGetCart.getBody().prettyPrint();

        // Ad 3
        JSONObject bodyRequestDelete = new JSONObject();
        bodyRequestDelete.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequestDelete.put("return_cart", true);

        String endpoint = "/cocart/v1/item";
        serviceHelper.sendDeleteRequest(bodyRequestDelete.toString(), endpoint);

        // Ad 4 - Shop page
    }
}
