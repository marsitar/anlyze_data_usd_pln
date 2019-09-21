package com.sitarski.marek.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.sitarski.marek.domain.CurrencyAPI;
import com.sitarski.marek.domain.ResultRow;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ApiParserTest {
  private ApiParser apiParser;

  @Before
  public void setUp() {
    apiParser = new ApiParser();
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void getCurrency_correctDateGiven_shouldReturnTrue() {
    final CurrencyAPI result = apiParser.getCurrency("2019-09-09");
    assertThat(result.getCode(),is("USD"));
    assertThat(result.getTable(),is("C"));
    assertThat(result.getCurrency(),is("dolar amerykański"));
  }

  @Test
  public void getCurrency_badDateGiven_shouldHandleError() {
    thrown.expect(IllegalStateException.class);
    final CurrencyAPI result = apiParser.getCurrency("2011-09-09");
  }
}
