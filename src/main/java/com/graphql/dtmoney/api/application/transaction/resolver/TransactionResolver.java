package com.graphql.dtmoney.api.application.transaction.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.dtmoney.api.application.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionResolver implements GraphQLResolver<Transaction> {
}
