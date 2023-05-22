package pl.programautomatycy.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCartRequestPOJO {

    @JsonProperty
    private Integer product_id;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private  Boolean return_cart;

    public AddItemToCartRequestPOJO(Integer productId, Integer quantity, Boolean returnCart){
        this.product_id = productId;
        this.quantity = quantity;
        this.return_cart = returnCart;
    }
}
