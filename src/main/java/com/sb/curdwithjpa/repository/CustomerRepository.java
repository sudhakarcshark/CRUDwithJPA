package com.sb.curdwithjpa.repository;

import com.sb.curdwithjpa.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Long>{

    Optional<CustomerModel> findByCustomerEmailAddress(String emailAddress);
    Optional<CustomerModel> findByCustomerMobileNumber(String mobileNumber);

}
