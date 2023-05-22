package pl.programautomatycy.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemResponse {

    @JsonProperty
    private String key;
    @JsonProperty
    private Integer product_id;
    @JsonProperty
    private Integer variation_id;
    @JsonProperty
    private Object variation;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private String data_hash;

    @JsonProperty
    private LineTaxData line_tax_data;

    @JsonProperty
    private Double line_subtotal;
    @JsonProperty
    private Double line_subtotal_tax;
    @JsonProperty
    private Double line_total;
    @JsonProperty
    private Double line_tax;
    @JsonProperty
    private Object data;
    @JsonProperty
    private String product_name;
    @JsonProperty
    private String product_title;
    @JsonProperty
    private String product_price;

    public String getKey() { return key; }
    public Integer getProductId() { return product_id; }
    public Integer getVariationId() { return variation_id; }
    public Object getVariation() { return variation; }
    public Integer getQuantity() { return quantity; }
    public String getDataHash() { return data_hash; }
    public LineTaxData getLineTaxData() { return line_tax_data; }
    public Double getLineSubtotal() { return line_subtotal; }
    public Double getLineSubtotalTax() { return line_subtotal_tax; }
    public Double getLineTotal() { return line_total; }
    public Double getLineTax() { return line_tax; }
    public Object getData() { return data; }
    public String getProductName() { return product_name; }
    public String getProductTitle() { return product_title; }
    public String getProductPrice() { return product_price; }
}
