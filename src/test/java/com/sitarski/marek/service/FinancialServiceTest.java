package com.sitarski.marek.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.sitarski.marek.domain.ResultRow;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FinancialServiceTest {

  private FinancialService financialService;

  @Before
  public void setUp() {
    financialService = new FinancialService();
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void processFinancialData_correctDateGiven_shouldReturnTrue() {
    final List<ResultRow> processedFinacialData = financialService.processFinancialData("2019-09-09");
    assertThat(processedFinacialData.get(0).getDate(),is("2019-09-09"));
  }

  @Test
  public void processFinancialData_badDateGiven_shouldHandleError() {
    thrown.expect(IllegalStateException.class);
    final List<ResultRow> processedFinacialData = financialService.processFinancialData("2012-09-09");
  }
}
