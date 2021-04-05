package com.ayigroup.mepv.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class InitElementProduct implements Serializable {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("customerId")
    private Long tempIdCustomer;

}
