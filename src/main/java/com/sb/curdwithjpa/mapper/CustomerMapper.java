package com.sb.curdwithjpa.mapper;


import com.sb.curdwithjpa.enums.CustomerStatus;
import com.sb.curdwithjpa.model.AddressModel;
import com.sb.curdwithjpa.model.CustomerModel;
import com.sb.curdwithjpa.request.CustomerAddress;
import com.sb.curdwithjpa.request.CustomerRequest;
import com.sb.curdwithjpa.response.AddressResponse;
import com.sb.curdwithjpa.response.CustomerResponse;

import static com.sb.curdwithjpa.utlls.AppUtils.generateOtp;
import static com.sb.curdwithjpa.utlls.AppUtils.generatePassword;

public class CustomerMapper {

    public static CustomerResponse modelToResponseMapper(CustomerModel model){

        return CustomerResponse.builder()
                .customerId(model.getCustomerId())
                .customerName(model.getCustomerName())
                .customerAge(model.getCustomerAge())
                .customerMobileNumber(model.getCustomerMobileNumber())
                .customerEmailAddress(model.getCustomerEmailAddress())
                .customerAddress(responseToAddressMapper(model.getCustomerAddress()))
                .createdDate(model.getCreatedDate())
                .status(model.getStatus())
                .verified(model.isVerified())
                .updatedDate(model.getUpdatedDate())
                .build();
    }

    public static CustomerModel requestToModel(CustomerRequest request){
        return CustomerModel.builder()
                .customerName(request.getCustomerName())
                .customerPassword(generatePassword())
                .customerAge(request.getCustomerAge())
                .customerMobileNumber(request.getCustomerMobileNumber())
                .customerEmailAddress(request.getCustomerEmailAddress())
                .customerAddress(requestToAddressModel(request.getCustomerAddress()))
                .customerOtp(generateOtp())
                .status(CustomerStatus.INACTIVE)
                .verified(Boolean.FALSE)
                .build();
    }

    public static AddressModel requestToAddressModel(CustomerAddress customerAddress){
        return AddressModel.builder()
                .city(customerAddress.getCity())
                .state(customerAddress.getState())
                .country(customerAddress.getCountry())
                .build();
    }

    public static AddressResponse responseToAddressMapper(AddressModel addressModel){
        return AddressResponse.builder()
                .city(addressModel.getCity())
                .state(addressModel.getState())
                .country(addressModel.getCountry())
                .build();
    }

}
