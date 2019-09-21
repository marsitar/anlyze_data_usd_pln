package com.sitarski.marek.parser;

import com.sitarski.marek.domain.CurrencyAPI;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ApiParser {

  final String ANSI_RED = "\u001B[31m";
  final String ANSI_RESET = "\u001B[0m";

  public CurrencyAPI getCurrency(String pastDate) {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(
        "http://api.nbp.pl/api/exchangerates/rates/C/USD/" + pastDate + "/" + getCurrentDate()
            + "?format=json");
    Response response = target.request().get();
    if (Response.Status.OK.equals(response.getStatusInfo())) {
      CurrencyAPI currency = response.readEntity(CurrencyAPI.class);
      response.close();
      return currency;
    } else {
      if (Response.Status.BAD_REQUEST.equals(response.getStatusInfo())) {
        System.out.println(ANSI_RED + "Błędny zakres daty." + ANSI_RESET);
      } else if (Status.NOT_FOUND.equals(response.getStatusInfo())) {
        System.out.println(ANSI_RED +"Brak danych dla podanej daty." + ANSI_RESET);
      }
      response.close();
      throw new IllegalStateException();
    }
  }

  private String getCurrentDate() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String currentFormattedDate = format.format(new Date());
    return currentFormattedDate;
  }
}
