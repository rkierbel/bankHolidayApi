package com.bankholiday;

import java.time.LocalDate;

/**
 * Each constant corresponds to a Holiday.<br>
 * Each constant is built using the month and day of the holiday.<br>
 * Adding the year, this constitutes the Holiday date (in format LocalDate).<br>
 * The year is passed dynamically so full dates can be adapted,<br>
 * to create a list of yearly holidays at run time for an instance of {@link HolidayGenerator}<br>
 */
public enum BelgianHoliday implements IsKnownCountry, CelebratesEaster {
  NEW_YEAR(1, 1),
  LABOUR_DAY(5, 1),
  NATIONAL_DAY(7, 21),
  ASSUMPTION(8, 15),
  ALL_SAINTS(11, 1),
  ALL_SOULS(11, 2),
  ARMISTICE(11, 11),
  KINGS_FEAST(11, 15),
  CHRISTMAS(12, 25),
  DAY_AFTER_CHRISTMAS(12, 26);

  private final int month;
  private final int day;

  BelgianHoliday(int month, int day) {
    this.month = month;
    this.day = day;
  }

  public LocalDate date(int year) {
    return LocalDate.of(year, this.month, this.day);
  }
}
