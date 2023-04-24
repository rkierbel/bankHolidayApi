package com.bankholiday.util;


import com.bankholiday.holiday.IsKnownHoliday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class HolidayFinder {

  public static boolean
  isAPublicHolidayEve(IsKnownHoliday perCountry,
                      LocalDateTime serviceDateTime) {

    return findPublicHoliday(
            perCountry,
            serviceDateTime.toLocalDate().atStartOfDay().plusDays(1))
            .isPresent();
  }

  public static boolean
  isAPublicHoliday(IsKnownHoliday perCountry,
                   LocalDateTime serviceDateTime) {
    Optional<LocalDate> aPublicHoliday = findPublicHoliday(perCountry, serviceDateTime);

    return aPublicHoliday.isPresent();
  }

  public static Optional<LocalDate>
  findPublicHoliday(IsKnownHoliday perCountry,
                    LocalDateTime serviceDateTime) {

    return HolidayGenerator.generateHolidays(
                    perCountry, serviceDateTime.getYear())
            .stream()
            .filter(holiday -> serviceDateTime.toLocalDate().equals(holiday))
            .findFirst();
  }
}
