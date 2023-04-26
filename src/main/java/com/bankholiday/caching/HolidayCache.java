package com.bankholiday.caching;

import com.bankholiday.country.IsKnownCountry;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class HolidayCache {

  private final IsKnownCountry forCountry;
  private final HashMap<Integer, Set<LocalDate>> holidaysPerYear;

  private HolidayCache(IsKnownCountry forCountry) {
    this.forCountry = forCountry;
    this.holidaysPerYear = new HashMap<>();
  }

  public static HolidayCache create(IsKnownCountry forCountry) {
    return new HolidayCache(forCountry);
  }

  public void cacheForYear(int year, Set<LocalDate> holidays) {
    holidaysPerYear.computeIfAbsent(year, k -> holidays);
  }

  public Set<LocalDate> fromCachePer(int year) {
    //no risk of NullPointerException since HashMap permits null keys
    return holidaysPerYear.getOrDefault(year, Collections.emptySet());
  }

  public IsKnownCountry country() {
    return this.forCountry;
  }
}
