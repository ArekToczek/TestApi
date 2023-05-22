package pl.programautomatycy.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRequestPOJO {

    @JsonProperty
    private String cart_item_key;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private  Boolean return_cart;

    public UpdateRequestPOJO(String cartItemKey, Integer quantity, Boolean returnCart){
        this.cart_item_key = cartItemKey;
        this.quantity = quantity;
        this.return_cart = returnCart;
    }
}
