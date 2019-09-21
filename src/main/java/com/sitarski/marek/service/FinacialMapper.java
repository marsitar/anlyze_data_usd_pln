package com.sitarski.marek.service;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.ColumnData;
import com.github.freva.asciitable.HorizontalAlign;
import com.sitarski.marek.domain.ResultRow;
import com.sitarski.marek.validator.InputDateFormatValidation;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FinacialMapper {
  final String ANSI_YELLOW = "\u001b[32m";
  final String ANSI_RESET = "\u001B[0m";
  final String ANSI_CYAN = "\u001B[36m";
  final String ANSI_RED = "\u001B[31m";

  public void doFinacialMapping() {
    Scanner scanner = new Scanner(System.in);
    InputDateFormatValidation inputDateFormatValidation = new InputDateFormatValidation();
    System.out.println(ANSI_YELLOW + "Witaj w programie sprawdzającym wartość dolara amerykańskiego "
        + "względem polskiej złotówki.\nPo podaniu daty otrzymasz tabele z poszczególnymi dniami "
        + "w przedziale od dnia podanego do dnia dzisiejszego. \nPoszczególne kolumny reprezentują "
        + "index dnia, datę, kwotę kupna, kwotę sprzedaży, \nróżnicę kursu sprzedaży względem dnia "
        + "poprzedniego i różnicę kursu kupna względem dnia poprzedniego." + ANSI_RESET);
    String valideDate = null;
    do {
      System.out.println(ANSI_CYAN + "Podaj datę w formacie RRRR-MM-DD:" + ANSI_RESET);
      String dateToCheck = scanner.next();
      if (inputDateFormatValidation.validateDate(dateToCheck)) {
        valideDate = dateToCheck;
      }
    } while (valideDate == null);

    FinancialService financialService = new FinancialService();
    try {
      printResults(financialService.processFinancialData(valideDate));
    } catch (IllegalStateException ise) {
      System.out.println(ANSI_RED + "Nastąpił błąd pobrania danych z API, następuje zamknięcie programu." + ANSI_RESET);
    }
    scanner.close();
  }

  private void printResults(List<ResultRow> processedFinacialData) {
    Character[] borderStyle = AsciiTable.FANCY_ASCII;
    System.out.println(
        AsciiTable.getTable(borderStyle, processedFinacialData, Arrays.asList(
            createColumn("Index",
                row -> String
                    .valueOf(processedFinacialData
                        .indexOf(row) + 1)),
            createColumn("Data", ResultRow::getDate),
            createColumn("Sprzedaż", resultRow -> resultRow.getAsk().toString()),
            createColumn("Kupno", resultRow -> resultRow.getBid().toString()),
            createColumn("Różnica sprzedaż", resultRow -> resultRow.getDiffAsk().toString()),
            createColumn("Różnica kupno", resultRow -> resultRow.getDiffBid().toString())
        )));
  }

  private ColumnData<ResultRow> createColumn(String name,
      Function<ResultRow, String> functionReference) {
    return new Column()
        .header(name)
        .headerAlign(HorizontalAlign.CENTER)
        .dataAlign(HorizontalAlign.LEFT)
        .with(functionReference);
  }
}
