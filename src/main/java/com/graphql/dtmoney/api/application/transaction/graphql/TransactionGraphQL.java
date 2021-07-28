package com.graphql.dtmoney.api.application.transaction.graphql;

import br.com.web.transaction.api.model.TransactionResponse;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.dtmoney.api.application.transaction.service.TransactionService;
import com.graphql.dtmoney.api.application.transaction.service.impl.TransactionServiceImpl;
import com.graphql.dtmoney.api.application.transaction.dto.TransactionPageResponse;
import com.graphql.dtmoney.api.application.transaction.input.TransactionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class TransactionGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  private TransactionService transactionService;

  public TransactionPageResponse listAllTransactions(Integer page, Integer size) {
    Pageable pagination = PageRequest.of(page, size, Sort.by("id"));
    return transactionService.findAllPageResponse(pagination);
  }

  public TransactionResponse createTransaction(@Valid TransactionInput input) {
    var transaction = transactionService.save(input);

    return new TransactionResponse()
            .id(transaction.getId())
            .category(transaction.getCategory())
            .title(transaction.getTitle())
            .amount(transaction.getAmount())
            .type(transaction.getType().toString().toLowerCase());
  }

  public TransactionResponse updateTransaction(@Valid TransactionInput input) {
    var transaction = transactionService.update(input);

    return new TransactionResponse()
            .id(transaction.getId())
            .category(transaction.getCategory())
            .title(transaction.getTitle())
            .amount(transaction.getAmount())
            .type(transaction.getType().toString().toLowerCase());
  }

  public Boolean deleteTransaction(Long id) {
    return transactionService.delete(id);
  }
}
