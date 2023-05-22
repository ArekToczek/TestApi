package rozwiazania;

import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;
import utils.JsonRequestBodyHelper;

public class Zadanie_4 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution() {

        // Ad 1
        JSONObject bodyRequestAddItem = JsonRequestBodyHelper.getJsonFromFile("request-shop-add-item-to-cart", "add_item_body");

        String endpointAddItem = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequestAddItem.toJSONString(), endpointAddItem);

        // Ad 2 - Postman

        // Ad 3
        JSONObject bodyRequestUpdate = JsonRequestBodyHelper.getJsonFromFile("request-shop-update-quantity", "update_body");

        String endpointUpdate = "/cocart/v1/item";
        serviceHelper.sendPostRequest(bodyRequestUpdate.toJSONString(), endpointUpdate);
    }
}
