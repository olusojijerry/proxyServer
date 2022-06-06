package com.zenithbank.integration.entity.flight;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Partner")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CorePartners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
    @Column(name = "PARTNER_NAME")
    String partnerName;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "CREDIT_ACCT_NO")
    String creditAcctNo;
    @Column(name = "CREDIT_ACCT_TYPE")
    String creditAccttype;
    @Column(name = "STATUS")
    String status;
    @Column(name = "CREATED_BY")
    String createdBy;
    @Column(name = "CREATED_DT")
    Date createdDt;
}
