package pl.programautomatycy.cart.service.test;

import org.testng.annotations.Test;

public class C_POSTmethodBodyString {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyString() {
        Integer productId = 142;
        Integer quantity = 10;
        Boolean returnCart = true;

        String bodyRequest = "{\n" +
                "    \"product_id\": " + productId + ",\n" +
                "    \"quantity\": " + quantity + ",\n" +
                "    \"return_cart\": " + returnCart + "\n" +
                "}";

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void calculateWithBodyString() {
        Boolean calculate = true;

        String bodyRequest = "{\n" +
                "    \"return\": " + calculate + "\n" +
                "}";

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }
}
