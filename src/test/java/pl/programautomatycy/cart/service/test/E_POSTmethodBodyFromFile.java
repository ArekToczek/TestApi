package pl.programautomatycy.cart.service.test;

import net.minidev.json.JSONObject;
import org.testng.annotations.Test;
import utils.JsonRequestBodyHelper;

public class E_POSTmethodBodyFromFile {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromFile(){
        JSONObject bodyRequest = JsonRequestBodyHelper.getJsonFromFile("request-shop-add-item-to-cart", "add_item_body");

        String endpoint = "/cocart/v1/add-item";
        serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
    }
}
