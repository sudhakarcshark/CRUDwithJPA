package com.sb.curdwithjpa.service;

import com.sb.curdwithjpa.request.CustomerRequest;
import com.sb.curdwithjpa.request.EmailRequest;
import com.sb.curdwithjpa.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<APIResponse> createCustomer(CustomerRequest request);
    ResponseEntity<APIResponse> getCustomers();
    ResponseEntity<APIResponse> getByCustomerId(long customerId);
    ResponseEntity<APIResponse> deleteByCustomerId(long customerId);
    ResponseEntity<APIResponse> upDateCustomerDetails(long customerId, CustomerRequest request);
    ResponseEntity<APIResponse> updateEmailAddress(long customerId, EmailRequest request);
}
