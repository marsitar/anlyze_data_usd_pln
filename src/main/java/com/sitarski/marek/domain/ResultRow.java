package com.sitarski.marek.domain;

import java.math.BigDecimal;

public class ResultRow {

  private String date;

  private BigDecimal bid;

  private BigDecimal ask;

  private BigDecimal diffBid;

  private BigDecimal diffAsk;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public BigDecimal getBid() {
    return bid;
  }

  public void setBid(BigDecimal bid) {
    this.bid = bid;
  }

  public BigDecimal getAsk() {
    return ask;
  }

  public void setAsk(BigDecimal ask) {
    this.ask = ask;
  }

  public BigDecimal getDiffBid() {
    return diffBid;
  }

  public void setDiffBid(BigDecimal diffBid) {
    this.diffBid = diffBid;
  }

  public BigDecimal getDiffAsk() {
    return diffAsk;
  }

  public void setDiffAsk(BigDecimal diffAsk) {
    this.diffAsk = diffAsk;
  }

  public ResultRow() {
  }

  @Override
  public String toString() {
    return "ResultRow{" +
        "date='" + date + '\'' +
        ", bid=" + bid +
        ", ask=" + ask +
        ", diffBid=" + diffBid +
        ", diffAsk=" + diffAsk +
        '}';
  }
}
