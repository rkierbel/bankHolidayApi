package com.bankholiday.holiday;

import com.bankholiday.caching.CacheRegistry;
import com.bankholiday.caching.HolidayCache;
import com.bankholiday.country.IsKnownCountry;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public final class HolidayGenerator {

  public static Set<LocalDate> generateHolidays(IsKnownCountry country, int year) {
    HolidayCache cachedCountry = CacheRegistry.getOrCreateForCountry(country);
    Set<LocalDate> holidaysForYear = cachedCountry.getOrCreateForYear(year);

    if (holidaysForYear.equals(Collections.emptySet())) {
      holidaysForYear = cachedCountry.getOrCreateForYear(year);
      CacheRegistry.perCountryCacheForYear(cachedCountry, year);
    }

    return holidaysForYear;
  }
}
