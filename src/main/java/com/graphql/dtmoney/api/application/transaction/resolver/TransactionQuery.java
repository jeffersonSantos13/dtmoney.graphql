package com.graphql.dtmoney.api.application.transaction.resolver;

import br.com.web.transaction.api.model.TransactionResponse;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import com.graphql.dtmoney.api.application.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionQuery implements GraphQLQueryResolver {

  @Autowired
  private TransactionRepository transactionRepository;

  public List<TransactionResponse> listAllTransactions() {
    return buildTransactionResponse(transactionRepository.findAll());
  }

  private List<TransactionResponse> buildTransactionResponse(List<Transaction> transactionList) {
    return transactionList
            .stream()
            .map(transaction -> new TransactionResponse()
                    .id(transaction.getId())
                    .amount(transaction.getAmount())
                    .title(transaction.getTitle())
                    .type(transaction.getType().toString().toLowerCase())
                    .category(transaction.getCategory()))
            .collect(Collectors.toList());
  }
}
