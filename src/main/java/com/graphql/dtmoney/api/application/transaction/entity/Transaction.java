package com.graphql.dtmoney.api.application.transaction.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Transaction {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull @NotEmpty
  private String title;

  @NotNull
  private Double amount;

  @Enumerated(EnumType.STRING)
  private TransactionType type;

  private String category;

  public Transaction() {
  }

  public Transaction(Long id, String title, Double amount, TransactionType type, String category) {
    this.id = id;
    this.title = title;
    this.amount = amount;
    this.type = type;
    this.category = category;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return id.equals(that.id) && title.equals(that.title) && amount.equals(that.amount) && type == that.type && category.equals(that.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, amount, type, category);
  }

  @Override
  public String toString() {
    return "Transaction{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", amount=" + amount +
            ", type=" + type +
            ", category='" + category + '\'' +
            '}';
  }
}
