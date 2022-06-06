package com.zenithbank.integration.entity.flight;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Users")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "USERNAME")
    String userName;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "CREATED_BY")
    String createdBy;

    @Column(name = "CREATED_DT")
    Date createdDt;
}
