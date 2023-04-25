package com.bankholiday.util;

import com.bankholiday.caching.CacheRegistry;
import com.bankholiday.caching.HolidayCache;
import com.bankholiday.country.IsKnownCountry;
import com.bankholiday.holiday.HasReligiousHolidays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public final class HolidayGenerator {

  static Set<LocalDate> generateHolidays(IsKnownCountry country, int year) {
    HolidayCache forCountry = CacheRegistry.getOrCreateForCountry(country);
    Set<LocalDate> holidaysForYear = forCountry.fromCachePer(year);

    if (holidaysForYear.equals(Collections.emptySet())) {
      holidaysForYear = Arrays.stream(country.holidays().values())
              .map(v -> v.date(year))
              .collect(Collectors.toSet());
      if (country instanceof HasReligiousHolidays c) {
        holidaysForYear.addAll(c.religiousHolidays(year));
      }
      forCountry.cache(year, holidaysForYear);
    }

    return holidaysForYear;
  }
}
