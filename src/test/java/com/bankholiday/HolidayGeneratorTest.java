package com.bankholiday;

import com.bankholiday.country.Belgium;
import com.bankholiday.util.HolidayGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HolidayGeneratorTest {

  @Test
  void givenBelgium2023_whenCallGenerateHolidays_generatesCorrectly() {
    Set<LocalDate> holidaysForBelgium2023 =
            HolidayGenerator.generateHolidays(Belgium.instance(), 2023);
    int expectedNumberOfHolidays = 13;
    assertEquals(
            expectedNumberOfHolidays,
            holidaysForBelgium2023.size());
  }
}
