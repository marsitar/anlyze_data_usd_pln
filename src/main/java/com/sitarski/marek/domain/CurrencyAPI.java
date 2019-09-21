package com.sitarski.marek.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurrencyAPI {

  @JsonProperty
  String table;

  @JsonProperty
  String currency;

  @JsonProperty
  String code;

  @JsonProperty
  List<ExchangeRateAPI> rates;

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<ExchangeRateAPI> getRates() {
    return rates;
  }

  public void setRates(List<ExchangeRateAPI> rates) {
    this.rates = rates;
  }

  @Override
  public String toString() {
    return "CurrencyAPI{" +
        "table='" + table + '\'' +
        ", currency='" + currency + '\'' +
        ", code='" + code + '\'' +
        ", rates=" + rates +
        '}';
  }
}
