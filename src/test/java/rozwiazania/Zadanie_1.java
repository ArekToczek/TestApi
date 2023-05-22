package rozwiazania;

import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

import java.util.HashMap;
import java.util.Map;

public class Zadanie_1 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        Map<String, Object> queryParamsBodyAddItem = new HashMap<>();
        queryParamsBodyAddItem.put("product_id", 142);
        queryParamsBodyAddItem.put("quantity", 1);
        queryParamsBodyAddItem.put("return_cart", true);

        String endpointAddItem = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBodyAddItem, endpointAddItem);

        // Ad 2 - Postman

        // Ad 3
        Map<String, Object> queryParamsBodyUpdate = new HashMap<>();
        queryParamsBodyUpdate.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        queryParamsBodyUpdate.put("quantity", 10);
        queryParamsBodyUpdate.put("return_cart", true);

        String endpointUpdate = "/cocart/v1/item";

        serviceHelper.sendPostRequest(queryParamsBodyUpdate, endpointUpdate);
    }
}
