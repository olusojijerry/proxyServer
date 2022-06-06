package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CorePartners;
import com.zenithbank.integration.repository.CorePartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CorePartnerServiceImpl implements CorePartnerService{
    @Autowired
    CorePartnerRepository corePartnerRepository;
    @Override
    public CorePartners saveOrUpdate(CorePartners corePartners) {
        return corePartnerRepository.save(corePartners);
    }

    @Override
    public Iterable<CorePartners> findAll(Predicate predicate) {
        return corePartnerRepository.findAll(predicate);
    }

    @Override
    public Optional<CorePartners> findById(Long id) {
        return corePartnerRepository.findById(id);
    }

    @Override
    public Optional<CorePartners> findOne(Predicate predicate) {
        return corePartnerRepository.findOne(predicate);
    }

    @Override
    public Page<CorePartners> findAll(Pageable pageable) {
        return corePartnerRepository.findAll(pageable);
    }

    @Override
    public Iterable<CorePartners> getAll() {
        return corePartnerRepository.findAll();
    }
}
