package com.bankholiday.holiday;

import com.bankholiday.caching.CacheRegistry;
import com.bankholiday.caching.HolidayCache;
import com.bankholiday.country.IsKnownCountry;
import com.bankholiday.holiday.typology.HasReligiousHolidays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public final class HolidayGenerator {

  public static Set<LocalDate> generateHolidays(IsKnownCountry country, int year) {
    HolidayCache cached = CacheRegistry.getOrCreateForCountry(country);
    Set<LocalDate> holidaysForYear = cached.fromCachePer(year);

    if (holidaysForYear.equals(Collections.emptySet())) {
      holidaysForYear = Arrays.stream(cached.country().holidays())
              .map(v -> v.date(year))
              .collect(Collectors.toSet());
      if (cached.country() instanceof HasReligiousHolidays c) {
        holidaysForYear.addAll(c.religiousHolidays(year));
      }
      cached.cacheForYear(year, holidaysForYear);
    }

    return holidaysForYear;
  }
}