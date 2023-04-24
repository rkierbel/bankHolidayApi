package com.bankholiday;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class HolidayGenerator {

  static Set<LocalDate> generateHolidays(IsKnownHoliday country, int year) {
    Set<LocalDate> foundHolidays =
            Arrays.stream(country.values())
                    .map(v -> v.date(year))
                    .collect(Collectors.toSet());

    if (country instanceof HasReligiousHolidays c) {
      foundHolidays.addAll(c.religiousHolidays(year));
    }

    return foundHolidays;
  }
}
