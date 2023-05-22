package pl.programautomatycy.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateResponse {

    @JsonProperty
    private String subtotal;
    @JsonProperty
    private Double subtotal_tax;
    @JsonProperty
    private String shipping_total;
    @JsonProperty
    private Double shipping_tax;
    @JsonProperty
    private Object shipping_taxes;
    @JsonProperty
    private Double discount_total;
    @JsonProperty
    private Double discount_tax;
    @JsonProperty
    private String cart_contents_total;
    @JsonProperty
    private Double cart_contents_tax;

    @JsonProperty
    private CartContentsTaxes cart_contents_taxes;

    @JsonProperty
    private String fee_total;
    @JsonProperty
    private Double fee_tax;
    @JsonProperty
    private Object fee_taxes;
    @JsonProperty
    private String total;
    @JsonProperty
    private Double total_tax;

    public String getSubtotal() { return subtotal; }
    public Double getSubtotalTax() { return subtotal_tax; }
    public String getShippingTotal() { return shipping_total; }
    public Double getShippingTax() { return shipping_tax; }
    public Object getShippingTaxes() { return shipping_taxes; }
    public Double getSiscountTotal() { return discount_total; }
    public Double getDiscountTax() { return discount_tax; }
    public String getCartContentsTotal() { return cart_contents_total; }
    public Double getCartContentsTax() { return cart_contents_tax; }
    public CartContentsTaxes getCartContentsTaxes() { return cart_contents_taxes; }
    public String getDeeTotal() { return fee_total; }
    public Double getFeeTax() { return fee_tax; }
    public Object getFeeTaxes() { return fee_taxes; }
    public String getTotal() { return total; }
    public Double getTotalTax() { return total_tax; }
}
