package com.bankholiday.util;


import com.bankholiday.holiday.IsKnownHoliday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class HolidayFinder {

  public static boolean
  isAPublicHolidayEve(IsKnownHoliday perCountry,
                      LocalDateTime forDateTime) {

    return findPublicHoliday(
            perCountry,
            forDateTime.toLocalDate().atStartOfDay().plusDays(1))
            .isPresent();
  }

  public static boolean
  isAPublicHoliday(IsKnownHoliday perCountry,
                   LocalDateTime forDateTime) {
    Optional<LocalDate> aPublicHoliday = findPublicHoliday(perCountry, forDateTime);

    return aPublicHoliday.isPresent();
  }

  public static Optional<LocalDate>
  findPublicHoliday(IsKnownHoliday perCountry,
                    LocalDateTime forDateTime) {

    return HolidayGenerator.generateHolidays(
                    perCountry, forDateTime.getYear())
            .stream()
            .filter(holiday -> forDateTime.toLocalDate().equals(holiday))
            .findFirst();
  }
}
