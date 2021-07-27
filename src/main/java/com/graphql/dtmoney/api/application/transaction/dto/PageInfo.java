package com.graphql.dtmoney.api.application.transaction.dto;

public class PageInfo {
  private Integer page;
  private int totalCount;
  private Boolean hasNextPage;
  private Boolean hasPreviousPage;

  public PageInfo() {
  }

  public PageInfo(Integer page, int totalCount, Boolean hasNextPage, Boolean hasPreviousPage) {
    this.page = page;
    this.totalCount = totalCount;
    this.hasNextPage = hasNextPage;
    this.hasPreviousPage = hasPreviousPage;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Boolean getHasNextPage() {
    return hasNextPage;
  }

  public void setHasNextPage(Boolean hasNextPage) {
    this.hasNextPage = hasNextPage;
  }

  public Boolean getHasPreviousPage() {
    return hasPreviousPage;
  }

  public void setHasPreviousPage(Boolean hasPreviousPage) {
    this.hasPreviousPage = hasPreviousPage;
  }

  public static PageInfo buildPageInfo(int totalPages, Integer page) {
    Boolean hasNextPage = (totalPages - (page+1) != 0 && totalPages > (page+1));
    Boolean hasPreviousPage = totalPages >= (page+1) && page != 0;
    return new PageInfo(page, totalPages, hasNextPage, hasPreviousPage);
  }
}
