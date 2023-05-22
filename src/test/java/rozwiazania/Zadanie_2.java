package rozwiazania;

import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

public class Zadanie_2 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        String bodyRequestAddItem = "{\n" +
                "    \"product_id\": 142,\n" +
                "    \"quantity\": 5,\n" +
                "    \"return_cart\": true\n" +
                "}";

        String endpointAddItem = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequestAddItem, endpointAddItem);

        // Ad 2 - Postman

        // Ad 3
        String bodyRequestUpdate = "{\n" +
                "    \"cart_item_key\": \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                "    \"return_cart\": true,\n" +
                "    \"quantity\": 15\n" +
                "}\n";

        String endpointUpdate = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequestUpdate, endpointUpdate);

    }
}
