package rozwiazania;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.serialising.AddItemToCartRequestPOJO;
import pl.programautomatycy.cart.service.test.serialising.UpdateRequestPOJO;

public class Zadanie_10 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        Integer productId = 142;
        Integer quantityAddItem = 10;
        Boolean returnCartAddItem = false;

        AddItemToCartRequestPOJO bodyRequestAddItem = new AddItemToCartRequestPOJO(productId, quantityAddItem, returnCartAddItem);

        String endpointAddItem = "/cocart/v1/add-item";
        Response responseAddItem = serviceHelper.sendPostRequest(bodyRequestAddItem, endpointAddItem);
        String key = responseAddItem.getBody().jsonPath().getString("key");
        String productName = responseAddItem.getBody().jsonPath().getString("product_name");

        // Ad 2
        String cartItemKey = key;
        Integer quantityUpdate = 2;
        Boolean returnCartUpdate = false;

        UpdateRequestPOJO bodyRequestUpdate = new UpdateRequestPOJO(cartItemKey, quantityUpdate, returnCartUpdate);
        String endpointUpdate = "/cocart/v1/item";
        Response responseUpdate = serviceHelper.sendPostRequest(bodyRequestUpdate, endpointUpdate);

        // Ad 3
        Assertions.assertEquals("The quantity for \"" + productName + "\" has decreased to \"2\".", responseUpdate.getBody().jsonPath().getString("message"));
        Assertions.assertEquals(2, responseUpdate.getBody().jsonPath().getInt("quantity"));

        // Ad 4
        quantityUpdate = 7;
        bodyRequestUpdate = new UpdateRequestPOJO(cartItemKey, quantityUpdate, returnCartUpdate);
        responseUpdate = serviceHelper.sendPostRequest(bodyRequestUpdate, endpointUpdate);

        // Ad 5
        Assertions.assertEquals("The quantity for \"" + productName + "\" has increased to \"7\".", responseUpdate.getBody().jsonPath().getString("message"));
        Assertions.assertEquals(7, responseUpdate.getBody().jsonPath().getInt("quantity"));
    }
}
