package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import com.zenithbank.integration.repository.CoreBookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CoreBookingDetailsServiceImpl implements CoreBookingDetailsService{
    @Autowired
    CoreBookingDetailsRepository coreBookingDetailsRepository;

    @Override
    public Page<CoreBookingDetails> findAllBookingDetails(Predicate predicate, Pageable pageable) {
        return coreBookingDetailsRepository.findAll(predicate, pageable);
    }

    @Override
    public CoreBookingDetails saveOrUpdate(CoreBookingDetails coreBookingDetails) {
        return coreBookingDetailsRepository.save(coreBookingDetails);
    }

    @Override
    public Optional<CoreBookingDetails> findById(Long id) {
        return coreBookingDetailsRepository.findById(id);
    }

    @Override
    public Optional<CoreBookingDetails> findOne(Predicate predicate) {
        return findOne(predicate);
    }

    @Override
    public Iterable<CoreBookingDetails> findAll(Predicate predicate) {
        return findAll(predicate);
    }

}
