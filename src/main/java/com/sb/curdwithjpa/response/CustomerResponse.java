package com.sb.curdwithjpa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sb.curdwithjpa.enums.CustomerStatus;
import com.sb.curdwithjpa.request.CustomerAddress;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CustomerResponse {

    @JsonProperty("customerId")
    private Long customerId;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("customerAge")
    private int customerAge;

    @JsonProperty("customerMobileNumber")
    private String customerMobileNumber;

    @JsonProperty("customerEmailAddress")
    private String customerEmailAddress;

    @JsonProperty("customerAddress")
    private AddressResponse customerAddress;

    @JsonProperty("status")
    private CustomerStatus status;

    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @JsonProperty("updatedDate")
    private LocalDateTime updatedDate;
}
