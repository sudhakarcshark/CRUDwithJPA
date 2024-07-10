package com.sb.curdwithjpa.controller;


import com.sb.curdwithjpa.request.CustomerRequest;
import com.sb.curdwithjpa.request.EmailRequest;
import com.sb.curdwithjpa.response.APIResponse;
import com.sb.curdwithjpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createCustomer(@RequestBody CustomerRequest request){

        return customerService.createCustomer(request);

    }

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("getById/{customerId}")
    public ResponseEntity<APIResponse> getAllCustomers(@PathVariable long customerId){

        return customerService.getByCustomerId(customerId);

    }
    @DeleteMapping("deleteById/{customerId}")
    public ResponseEntity<APIResponse> deleteById(@PathVariable long customerId){

        return customerService.deleteByCustomerId(customerId);

    }
    @PutMapping("/update/{customerId}")
    public ResponseEntity<APIResponse> upDate(@PathVariable long customerId, @RequestBody CustomerRequest request){

        return customerService.upDateCustomerDetails(customerId, request);
    }

    @PatchMapping("/updateEmailAddress/{customerId}")
    public ResponseEntity<APIResponse> upDateEmailAddress(@PathVariable long customerId, @RequestBody EmailRequest request) {

        return customerService.updateEmailAddress(customerId, request);
    }
}





