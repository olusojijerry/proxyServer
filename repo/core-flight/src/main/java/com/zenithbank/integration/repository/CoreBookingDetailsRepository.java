package com.zenithbank.integration.repository;

import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CoreBookingDetailsRepository extends PagingAndSortingRepository<CoreBookingDetails, Long>, QuerydslPredicateExecutor<CoreBookingDetails> {

}
