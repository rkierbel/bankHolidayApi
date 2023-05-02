package com.bankholiday.holiday;

import com.bankholiday.country.Belgium;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HolidayFinderTest {

  @Test
  void givenBelgium2023_whenTestFindsEasterMonday_returnsTrue() {
    assertTrue(HolidayFinder.isAPublicHoliday(
            Belgium.instance(),
            LocalDateTime.of(2023, 4, 10, 10, 0)));

    assertFalse(HolidayFinder.isAPublicHoliday(
            Belgium.instance(),
            LocalDateTime.of(2023, 3, 9, 10, 0)));
  }

  @Test
  void givenBelgium2023_whenTestFindsEasterMondayEve_returnsTrue() {
    assertTrue(HolidayFinder.isAPublicHolidayEve(
            Belgium.instance(),
            LocalDateTime.of(2023, 4, 9, 10, 0)));

    assertFalse(HolidayFinder.isAPublicHolidayEve(
            Belgium.instance(),
            LocalDateTime.of(2023, 4, 10, 10, 0)));
  }



}
