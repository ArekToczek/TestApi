package pl.programautomatycy.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartContentsTaxes {

    @JsonProperty("1")
    private Double cartContentsTaxes1;

    public Double getCartContentsTaxes1() {return cartContentsTaxes1; }
}
