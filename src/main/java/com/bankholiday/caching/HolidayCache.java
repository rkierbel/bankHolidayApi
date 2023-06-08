package com.bankholiday.caching;

import com.bankholiday.country.IsKnownCountry;
import com.bankholiday.holiday.typology.HasReligiousHolidays;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class HolidayCache {

  private final IsKnownCountry cachedCountry;
  private final HashMap<Integer, Set<LocalDate>> holidaysPerYear;

  private HolidayCache(IsKnownCountry cachedCountry) {
    this.cachedCountry = cachedCountry;
    this.holidaysPerYear = new HashMap<>();
  }

  public static HolidayCache create(IsKnownCountry cachedCountry) {
    return new HolidayCache(cachedCountry);
  }

  public Set<LocalDate> getOrCreateForYear(int year) {
    Set<LocalDate> holidays =
            Arrays.stream(cachedCountry.holidays())
                    .map(holiday -> holiday.date(year))
                    .collect(Collectors.toSet());

    if (cachedCountry instanceof HasReligiousHolidays country) {
      holidays.addAll(country.religiousHolidays(year));
    }

    return holidaysPerYear.computeIfAbsent(
            year,
            value -> holidays);
  }

  public IsKnownCountry country() {
    return cachedCountry;
  }
}
