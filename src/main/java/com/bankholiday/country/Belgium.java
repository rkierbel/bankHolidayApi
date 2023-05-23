package com.bankholiday.country;

import com.bankholiday.holiday.typology.CelebratesEaster;
import com.bankholiday.holiday.IsKnownHoliday;

import java.time.LocalDate;

public class Belgium implements IsKnownCountry, CelebratesEaster {

  private static final Belgium instance = new Belgium();

  private Belgium() {
  }

  public static Belgium instance() {
    return instance;
  }

  @Override
  public String name() {
    return "BELGIUM";
  }

  @Override
  public IsKnownHoliday[] holidays() {
    return Holiday.values();
  }

  public enum Holiday implements IsKnownHoliday, CelebratesEaster {
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

    Holiday(int month, int day) {
      this.month = month;
      this.day = day;
    }

    public LocalDate date(int year) {
      return LocalDate.of(year, this.month, this.day);
    }
  }
}
