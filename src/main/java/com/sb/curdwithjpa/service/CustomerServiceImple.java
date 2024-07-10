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
import java.util.Optional;

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

      Optional<CustomerModel> optionalCustomerModel = customerRepository.findById(customerId);
      if (!optionalCustomerModel.isPresent()){
          return ResponseEntity.ok(
                  APIResponse.builder()
                          .errorCode(CUSTOMER_NOT_EXISTS_CODE)
                          .errorMessage(CUSTOMER_NOT_EXISTS)
                          .data(List.of())
                          .build()
          );
      }

    CustomerModel model = optionalCustomerModel.get();
      CustomerResponse response = modelToResponseMapper(model);
      return ResponseEntity.ok(
              APIResponse.builder()
                      .errorCode(SUCCESS_CODE)
                      .errorMessage(SUCCESSFULLY_RETRIEVED)
                      .data(response)
                      .build()
      );

    }

    @Override
    public ResponseEntity<APIResponse> deleteByCustomerId(long customerId) {
      Optional<CustomerModel> modelCustomer = customerRepository.findById(customerId);
      if (!modelCustomer.isPresent()){
          return ResponseEntity.ok(
                  APIResponse.builder()
                          .errorCode(CUSTOMER_NOT_EXISTS_CODE)
                          .errorMessage(CUSTOMER_NOT_EXISTS)
                          .data(List.of())
                          .build()
          );
      }
      customerRepository.deleteById(customerId);
      return ResponseEntity.ok(
              APIResponse.builder()
                      .errorCode(SUCCESS_CODE)
                      .errorMessage(SUCCESSFULLY_DELETED)
                      .data(List.of())
                      .build()
      );

    }

    @Override
    public ResponseEntity<APIResponse> upDateCustomerDetails(long customerId, CustomerRequest request) {
      Optional<CustomerModel> modelCustomer = customerRepository.findById(customerId);
      if (modelCustomer.isPresent()){
          CustomerModel model = modelCustomer.get();
          model.setCustomerName(request.getCustomerName());
          model.setCustomerAge(request.getCustomerAge());
          model.setCustomerMobileNumber(request.getCustomerMobileNumber());
          model.setCustomerEmailAddress(request.getCustomerEmailAddress());
          model.setCustomerAddress(request.getCustomerAddress());
          model = customerRepository.save(model);

          return ResponseEntity.ok(
                  APIResponse.builder()
                          .errorCode(SUCCESS_CODE)
                          .errorMessage(SUCCESSFULLY_UPDATED)
                          .data(modelToResponseMapper(model))
                          .build()
          );
      }else {
          return ResponseEntity.ok(
                  APIResponse.builder()
                          .errorCode(CUSTOMER_NOT_EXISTS_CODE)
                          .errorMessage(CUSTOMER_NOT_EXISTS)
                          .data(List.of())
                          .build()
          );
      }
    }
}
