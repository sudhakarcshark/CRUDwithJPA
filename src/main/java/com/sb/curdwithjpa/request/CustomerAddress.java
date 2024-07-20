package com.sb.curdwithjpa.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CustomerAddress {

   // @JsonProperty("city")
    @NotBlank(message = "Customer city is Mandatory")
    private String city;

   // @JsonProperty("state")
    @NotBlank(message = "Customer state is Mandatory")
    private String state;

   // @JsonProperty("country")
    @NotBlank(message = "Customer country is Mandatory")
    private String country;
}
