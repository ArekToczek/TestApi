package rozwiazania;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import pl.programautomatycy.cart.service.test.serialising.*;

public class Zadanie_8 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        Integer productId = 142;
        Integer quantityAddItem = 10;
        Boolean returnCartAddItem = false;

        AddItemToCartRequestPOJO bodyRequestAddItem = new AddItemToCartRequestPOJO(productId, quantityAddItem, returnCartAddItem);

        String endpoint = "/cocart/v1/add-item";
        Response response = serviceHelper.sendPostRequest(bodyRequestAddItem, endpoint);
        String key = response.getBody().jsonPath().getString("key");

        // Ad 2
        String cartItemKey = key;
        Integer quantityUpdate = 2;
        Boolean returnCartUpdate = false;

        UpdateRequestPOJO bodyRequestUpdate = new UpdateRequestPOJO(cartItemKey, quantityUpdate, returnCartUpdate);
        String endpointUpdate = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequestUpdate, endpointUpdate);
    }
}
