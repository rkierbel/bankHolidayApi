package com.bankholiday.util;


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
  findPublicHoliday(IsKnownCountry perCountry,
                    LocalDateTime forDateTime) {

    return HolidayGenerator.generateHolidays(perCountry, forDateTime.getYear())
            .stream()
            .filter(holiday -> forDateTime.toLocalDate().equals(holiday))
            .findFirst();
  }
}
