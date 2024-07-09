package com.sb.curdwithjpa.service;


import com.sb.curdwithjpa.enums.CustomerStatus;
import com.sb.curdwithjpa.model.CustomerModel;
import com.sb.curdwithjpa.repository.CustomerRepository;
import com.sb.curdwithjpa.request.CustomerRequest;
import com.sb.curdwithjpa.response.APIResponse;
import com.sb.curdwithjpa.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sb.curdwithjpa.constants.AppConstants.*;
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
        List<CustomerModel> customerDetails = customerRepository.findAll();
        List<CustomerResponse> customers = customerDetails.stream()
                .map(customerModel->modelToResponseMapper(customerModel)).toList();
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(SUCCESS_CODE)
                        .errorMessage(SUCCESSFULLY_RETRIEVED)
                        .data(customers)
                        .build()
        );
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
