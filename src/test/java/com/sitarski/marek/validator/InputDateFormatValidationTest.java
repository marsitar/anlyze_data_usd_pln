package com.sitarski.marek.validator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class InputDateFormatValidationTest {

  private InputDateFormatValidation inputDateFormatValidation;

  @Before
  public void setUp() {
    inputDateFormatValidation = new InputDateFormatValidation();
  }

  @Test
  public void validateDate_badDateGiven_shouldReturnFalse() {
    final String inputDate = "2019.10.10";
    final boolean result = inputDateFormatValidation.validateDate(inputDate);
    assertThat(result, is(false));
  }

  @Test
  public void validateDate_emptyGiven_shouldReturnFalse() {
    final String inputDate = "";
    final boolean result = inputDateFormatValidation.validateDate(inputDate);
    assertThat(result, is(false));
  }

  @Test
  public void validateDate_correctDateGiven_shouldReturnTrue() {
    final String inputDate = "2019-10-10";
    final boolean result = inputDateFormatValidation.validateDate(inputDate);
    assertThat(result, is(true));
  }
}
