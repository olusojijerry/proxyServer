package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CoreBookingDetailsService {
    Page<CoreBookingDetails> findAllBookingDetails(Predicate predicate, Pageable pageable);
    CoreBookingDetails saveOrUpdate(CoreBookingDetails coreBookingDetails);
    Optional<CoreBookingDetails> findById(Long id);
    Optional<CoreBookingDetails> findOne(Predicate predicate);
    Iterable<CoreBookingDetails> findAll(Predicate predicate);
}
