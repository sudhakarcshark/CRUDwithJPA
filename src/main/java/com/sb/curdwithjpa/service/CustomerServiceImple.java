package com.sb.curdwithjpa.service;


import com.sb.curdwithjpa.enums.CustomerStatus;
import com.sb.curdwithjpa.model.CustomerModel;
import com.sb.curdwithjpa.repository.CustomerRepository;
import com.sb.curdwithjpa.request.CustomerRequest;
import com.sb.curdwithjpa.response.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.sb.curdwithjpa.constants.AppConstants.SUCCESSFULLY_STORED;
import static com.sb.curdwithjpa.constants.AppConstants.SUCCESS_CODE;
import static com.sb.curdwithjpa.mapper.CustomerMapper.modelToResponseMapper;
import static com.sb.curdwithjpa.mapper.CustomerMapper.requestToModel;


@Service
@RequiredArgsConstructor
public class CustomerServiceImple implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public ResponseEntity<APIResponse> createCustomer(CustomerRequest request) {

        CustomerModel customerModel = customerRepository.save(requestToModel(request));
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_STORED)
                        .data(modelToResponseMapper(customerModel))
                        .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getCustomers() {
        return null;
    }

    @Override
    public ResponseEntity<APIResponse> getByCustomerId(long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<APIResponse> deleteByCustomerId(long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<APIResponse> upDateCustomerDetails(long customerId, CustomerRequest request) {
        return null;
    }
}
