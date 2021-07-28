package com.graphql.dtmoney.api.application.transaction.service;

import com.graphql.dtmoney.api.application.transaction.dto.TransactionPageResponse;
import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import com.graphql.dtmoney.api.application.transaction.input.TransactionInput;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface TransactionService {

  TransactionPageResponse findAllPageResponse(Pageable pageable);

  Transaction save(@Valid TransactionInput input);

  Transaction update(@Valid TransactionInput input);

  Boolean delete(Long id);
}
