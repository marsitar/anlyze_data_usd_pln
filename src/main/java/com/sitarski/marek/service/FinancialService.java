package com.sitarski.marek.service;

import com.sitarski.marek.domain.CurrencyAPI;
import com.sitarski.marek.domain.ExchangeRateAPI;
import com.sitarski.marek.domain.ResultRow;
import com.sitarski.marek.parser.ApiParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FinancialService {

  public List<ResultRow> processFinancialData(String date) throws IllegalStateException {
    List<ResultRow> processedFinacialData = new ArrayList<>();
    List<ExchangeRateAPI> exchangeRateAPIs = getExchangeRates(date);
    final ExchangeRateAPI prevExchangeRateAPI = exchangeRateAPIs.get(0);
    exchangeRateAPIs.forEach(nextExchangeRateAPI -> {
      ResultRow resultRow = new ResultRow();
      resultRow.setDate(nextExchangeRateAPI.getEffectiveDate());
      resultRow.setAsk(nextExchangeRateAPI.getAsk());
      resultRow.setBid(nextExchangeRateAPI.getBid());
      resultRow.setDiffAsk(nextExchangeRateAPI.getAsk().subtract(prevExchangeRateAPI.getAsk()));
      resultRow.setDiffBid(nextExchangeRateAPI.getBid().subtract(prevExchangeRateAPI.getBid()));
      prevExchangeRateAPI.setAsk(nextExchangeRateAPI.getAsk());
      prevExchangeRateAPI.setBid(nextExchangeRateAPI.getBid());
      processedFinacialData.add(resultRow);
    });
    return processedFinacialData;
  }

  private List<ExchangeRateAPI> getExchangeRates(String date) throws IllegalStateException {
    ApiParser apiParser = new ApiParser();
    CurrencyAPI currency = apiParser.getCurrency(date);
    return getExchangeRatesFromCurrency(currency);
  }

  private List<ExchangeRateAPI> getExchangeRatesFromCurrency(CurrencyAPI currency) {
    return Optional.ofNullable(currency)
        .map(CurrencyAPI::getRates)
        .orElseThrow(() -> new IllegalStateException());
  }
}
