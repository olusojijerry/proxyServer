package com.zenithbank.integration.services;

import com.querydsl.core.types.Predicate;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.repository.CoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CoreUserServiceImpl implements CoreUserService{
    @Autowired
    CoreUserRepository coreUserRepository;
    @Override
    public CoreUser saveOrUpdate(CoreUser user) {
        return coreUserRepository.save(user);
    }

    @Override
    public Page<CoreUser> findAll(Pageable pageable) {
        return coreUserRepository.findAll(pageable);
    }

    @Override
    public Optional<CoreUser> findById(Long id) {
        return coreUserRepository.findById(id);
    }

    @Override
    public Optional<CoreUser> findOne(Predicate predicate) {
        return coreUserRepository.findOne(predicate);
    }

    @Override
    public Page<CoreUser> findAll(Predicate predicate, Pageable pageable) {
        return coreUserRepository.findAll(predicate, pageable);
    }

    @Override
    public Boolean isUserExist(Predicate predicate) {
        return coreUserRepository.exists(predicate);
    }
}
