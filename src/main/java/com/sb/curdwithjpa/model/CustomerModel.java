package com.sb.curdwithjpa.model;

import com.sb.curdwithjpa.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
@Entity
@Table(name = "customer_profile")
public class CustomerModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long customerId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerPassword")
    private String customerPassword;

    @Column(name = "customerAge")
    private int customerAge;

    @Column(name = "customerMobileNumber")
    private String customerMobileNumber;

    @Column(name = "customerEmailAddress")
    private String customerEmailAddress;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private AddressModel customerAddress;

    @Column(name = "status")
    private CustomerStatus status;

    @Column(name = "customerOtp")
    private String customerOtp;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
