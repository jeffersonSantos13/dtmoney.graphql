package com.graphql.dtmoney.api.application.transaction.resolver;

import br.com.web.transaction.api.model.TransactionResponse;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import com.graphql.dtmoney.api.application.transaction.entity.TransactionType;
import com.graphql.dtmoney.api.application.transaction.input.TransactionInput;
import com.graphql.dtmoney.api.application.transaction.repository.TransactionRepository;
import com.graphql.dtmoney.api.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class TransactionMutation implements GraphQLMutationResolver {

  private static final String CATEGORY = "default";

  @Autowired
  private TransactionRepository transactionRepository;

  public TransactionResponse createTransaction(@Valid TransactionInput input) {
    var transaction = transactionRepository.save(buildTransactionInputToTransaction(input));

    return new TransactionResponse()
            .id(transaction.getId())
            .category(transaction.getCategory())
            .title(transaction.getTitle())
            .amount(transaction.getAmount())
            .type(transaction.getType().toString().toLowerCase());
  }

  private Transaction buildTransactionInputToTransaction(TransactionInput input) {
    var transaction = new Transaction();

    transaction.setAmount(StringUtils.isEmpty(input.getAmount()) ? 0.0 : Double.valueOf(input.getAmount()));
    transaction.setCategory(StringUtils.isEmpty(input.getCategory()) ? CATEGORY : input.getCategory());
    transaction.setTitle(input.getTitle());
    transaction.setType(input.getType().equals(TransactionType.DEPOSIT) ?
            TransactionType.DEPOSIT : TransactionType.WITHDRAW
    );

    return transaction;
  }
}
