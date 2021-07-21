package com.graphql.dtmoney.api.application.transaction.repository;

import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
