package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CoreUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CoreUserService {
    CoreUser saveOrUpdate(CoreUser user);
    Page<CoreUser> findAll(Pageable pageable);
    Optional<CoreUser> findById(Long id);
    Optional<CoreUser> findOne(Predicate predicate);
    Page<CoreUser> findAll(Predicate predicate, Pageable pageable);

    Boolean isUserExist(Predicate predicate);
}
