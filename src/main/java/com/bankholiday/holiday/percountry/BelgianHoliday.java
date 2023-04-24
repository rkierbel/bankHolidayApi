package com.bankholiday.holiday.percountry;

import com.bankholiday.holiday.CelebratesEaster;
import com.bankholiday.holiday.IsKnownHoliday;

import java.time.LocalDate;

public enum BelgianHoliday implements IsKnownHoliday, CelebratesEaster {
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
