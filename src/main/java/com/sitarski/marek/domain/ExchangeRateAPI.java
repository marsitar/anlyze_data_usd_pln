package com.sitarski.marek.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class ExchangeRateAPI {

  @JsonProperty
  String no;

  @JsonProperty
  String effectiveDate;

  @JsonProperty
  BigDecimal bid;

  @JsonProperty
  BigDecimal ask;

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
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

  @Override
  public String toString() {
    return "ExchangeRateAPI{" +
        "no='" + no + '\'' +
        ", effectiveDate='" + effectiveDate + '\'' +
        ", bid=" + bid +
        ", ask=" + ask +
        '}';
  }
}
