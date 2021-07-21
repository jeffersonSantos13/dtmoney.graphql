package com.graphql.dtmoney.api.application.transaction.input;

import com.graphql.dtmoney.api.application.transaction.entity.TransactionType;
import graphql.schema.GraphQLInputType;

public class TransactionInput implements GraphQLInputType {
  @Override
  public String getName() {
    return this.getTitle();
  }

  private Long id;
  private String title;
  private Double amount;
  private TransactionType type;
  private String category;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
