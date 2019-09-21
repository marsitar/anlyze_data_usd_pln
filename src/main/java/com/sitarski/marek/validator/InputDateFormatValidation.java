package com.sitarski.marek.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class InputDateFormatValidation {

  final String ANSI_RED = "\u001B[31m";
  final String ANSI_RESET = "\u001B[0m";
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public boolean validateDate(String textDate) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    LocalDate validatedDate = null;
    Boolean isDateValid = false;
    try {
      validatedDate = simpleDateFormat
          .parse(textDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    } catch (ParseException e) {
      System.out.println(ANSI_RED + "Błędna data, wpisz date w formacie YYYY-MM-DD:\n" + ANSI_RESET);
    }
    if (validatedDate != null) {
      isDateValid = true;
    }
    return isDateValid;
  }
}
