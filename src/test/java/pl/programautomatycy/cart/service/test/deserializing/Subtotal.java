package pl.programautomatycy.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subtotal {

    @JsonProperty("1")
    private Double subtotal1;

    public Double getSubtotal1() {return subtotal1; }
}
