package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class G_DELETEmethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void removeItemFromCart(){

            String endpoint = "/cocart/v1/item";
            String parameters = "?cart_item_key=a8baa56554f96369ab93e4f3bb068c22&return_cart=true";

            Response response = serviceHelper.sendDeleteRequest(endpoint + parameters);

            response.getBody().prettyPrint();
    }

    @Test
    public void removeItemFromCartWithBody(){

        String bodyRequest = "{\n" +
                "    \"cart_item_key\": \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                "    \"return_cart\": \"true\"\n" +
                "}";
        String endpoint = "/cocart/v1/item";

        Response response = serviceHelper.sendDeleteRequest(bodyRequest, endpoint);

        response.getBody().prettyPrint();
    }
}
