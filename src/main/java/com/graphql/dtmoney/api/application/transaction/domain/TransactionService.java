package com.graphql.dtmoney.api.application.transaction.domain;

import br.com.web.transaction.api.model.TransactionResponse;
import com.graphql.dtmoney.api.application.transaction.dto.TransactionPageResponse;
import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import com.graphql.dtmoney.api.application.transaction.entity.TransactionType;
import com.graphql.dtmoney.api.application.transaction.input.TransactionInput;
import com.graphql.dtmoney.api.application.transaction.repository.TransactionRepository;
import com.graphql.dtmoney.api.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.graphql.dtmoney.api.application.transaction.dto.PageInfo.buildPageInfo;

@Service
public class TransactionService {

  private static final String CATEGORY = "default";

  @Autowired
  private TransactionRepository transactionRepository;

  public TransactionPageResponse findAllPageResponse(Pageable pageable) {
    Page<Transaction> listTransactions = transactionRepository.findAll(pageable);

    return new TransactionPageResponse(
            buildPageInfo(listTransactions.getTotalPages(), listTransactions.getNumber()),
            buildTransactionResponse(listTransactions.getContent())
    );
  }

  public Transaction save(@Valid TransactionInput input) {
    return transactionRepository.save(buildTransactionInputToTransaction(input));
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
