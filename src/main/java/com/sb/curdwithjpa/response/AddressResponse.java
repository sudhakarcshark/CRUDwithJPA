package com.sb.curdwithjpa.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class AddressResponse {

    @NotBlank(message = "Customer City is Mandatory")
    private String city;
    @NotBlank(message = "Customer State is Mandatory")
    private String state;
    @NotBlank(message = "Customer Country is Mandatory")
    private String country;
}
