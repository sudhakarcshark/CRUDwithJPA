package com.sb.curdwithjpa.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class CustomerRequest {

    @NotBlank(message = "Please Provide Username")
    private String customerName;

    private int customerAge;

    @NotBlank(message = "Mobile Number Should Not Be Empty")
    @Size(min = 10,max = 10,message = "Please Input Valid Mobile Number")
    private String customerMobileNumber;

    @NotBlank(message = "Email_Id Should not be Empty")
    @Email(message = "Please Provide Valid Email_Id")
    private String customerEmailAddress;

    @NotBlank(message = "Please Provide Address")
    private String customerAddress;
}
