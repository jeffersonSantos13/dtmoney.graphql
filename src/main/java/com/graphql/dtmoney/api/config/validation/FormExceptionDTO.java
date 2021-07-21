package com.graphql.dtmoney.api.config.validation;

public class FormExceptionDTO {

  private String field;
  private String error;

  public FormExceptionDTO(String field, String error) {
    this.field = field;
    this.error = error;
  }

  public String getField() {
    return field;
  }

  public String getError() {
    return error;
  }
}
