package com.bankholiday.caching;

import com.bankholiday.country.IsKnownCountry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class CacheRegistry {

  private static final List<HolidayCache> registry = new ArrayList<>(Collections.emptyList());

  public static HolidayCache getOrCreateForCountry(IsKnownCountry country) {
    Optional<HolidayCache> cacheForCountry = getByCountry(country);

    if (cacheForCountry.isPresent()) {
      return cacheForCountry.get();
    } else {
      HolidayCache newCache = HolidayCache.create(country);
      registry.add(newCache);
      return newCache;
    }
  }

  public static void perCountryCacheForYear(HolidayCache cacheForCountry,
                                            int year) {
    cacheForCountry.getOrCreateForYear(year);
  }

  private static Optional<HolidayCache> getByCountry(IsKnownCountry country) {
    return registry.stream()
            .filter(hc -> hc.country().name().equals(country.name()))
            .findFirst();
  }
}
