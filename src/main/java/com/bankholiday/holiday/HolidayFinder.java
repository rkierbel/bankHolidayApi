package com.bankholiday.holiday;


import com.bankholiday.caching.CacheRegistry;
import com.bankholiday.caching.HolidayCache;
import com.bankholiday.country.IsKnownCountry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class HolidayFinder {

  public static boolean
  isAPublicHolidayEve(IsKnownCountry perCountry,
                      LocalDateTime forDateTime) {

    return findPublicHoliday(
            perCountry,
            forDateTime.toLocalDate().atStartOfDay().plusDays(1))
            .isPresent();
  }

  public static boolean
  isAPublicHoliday(IsKnownCountry perCountry,
                   LocalDateTime forDateTime) {
    Optional<LocalDate> aPublicHoliday = findPublicHoliday(perCountry, forDateTime);
    return aPublicHoliday.isPresent();
  }

  public static Optional<LocalDate>
  findPublicHoliday(IsKnownCountry country,
                    LocalDateTime dateTime) {
    HolidayCache cacheForCountry = CacheRegistry.getOrCreateForCountry(country);

    return cacheForCountry
            .getOrCreateForYear(dateTime.getYear()).stream()
            .filter(dateTime.toLocalDate()::equals)
            .findFirst();
  }
}
