package com.graphql.dtmoney.api.application.transaction.dto;

import br.com.web.transaction.api.model.TransactionResponse;

import java.util.List;

public class TransactionPageResponse {
  private PageInfo pageInfo;
  private List<TransactionResponse> transactionResponse;

  public TransactionPageResponse() {
  }

  public TransactionPageResponse(PageInfo pageInfo, List<TransactionResponse> transactionResponse) {
    this.pageInfo = pageInfo;
    this.transactionResponse = transactionResponse;
  }

  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  public List<TransactionResponse> getTransactionResponse() {
    return transactionResponse;
  }

  public void setTransactionResponse(List<TransactionResponse> transactionResponse) {
    this.transactionResponse = transactionResponse;
  }
}
