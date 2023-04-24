package com.bankholiday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * PublicHolidayHelper is statically generated for the current year upon class first instantiation.<br>
 * The list of allHolidays for a given year is created streaming over {@link HolidayGenerator} enum constants.<br>
 * PublicHolidayHelper for a given year is mapped to the appropriate year as int.<br>
 * If a PublicHolidayHelper for a given exists, it is simply retrieved based on the year passed to getInstance().<br>
 */
public final class HolidayGenerator {

  Set<LocalDate> generateHolidays(IsKnownCountry country, int year) {

    return Arrays.stream(country.values())
            .map(v -> v.date(year))
            .collect(Collectors.toSet());
  }

  public static <T extends IsKnownCountry> boolean
  isAPublicHolidayEve(Class<T> forCountry, LocalDateTime serviceDateTime) {

    return findPublicHoliday(
            forCountry,
            serviceDateTime.toLocalDate().atStartOfDay().plusDays(1))
            .isPresent();
  }

  public static <T extends IsKnownCountry> boolean
  isAPublicHoliday(Class<T> forCountry, LocalDateTime serviceDateTime) {
    Optional<LocalDate> aPublicHoliday = findPublicHoliday(forCountry, serviceDateTime);

    return aPublicHoliday.isPresent();
  }

  public static <T extends IsKnownCountry> Optional<LocalDate>
  findPublicHoliday(Class<T> forCountry, LocalDateTime serviceDateTime) {

    /*return cache.getAllHolidays().stream()
            .filter(publicHoliday -> serviceDateTime.toLocalDate().equals(publicHoliday))
            .findFirst();*/
    return null;
  }

}
