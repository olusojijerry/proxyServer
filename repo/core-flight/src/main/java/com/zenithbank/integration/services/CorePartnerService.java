package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CorePartners;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CorePartnerService {
    CorePartners saveOrUpdate(CorePartners corePartners);
    Iterable<CorePartners> findAll(Predicate predicate);
    Optional<CorePartners> findById(Long id);
    Optional<CorePartners> findOne(Predicate predicate);
    Page<CorePartners> findAll(Pageable pageable);
    Iterable<CorePartners> getAll();
}
