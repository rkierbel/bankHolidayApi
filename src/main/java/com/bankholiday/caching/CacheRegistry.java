package com.bankholiday.caching;

import com.bankholiday.country.IsKnownCountry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CacheRegistry {

  private static final List<HolidayCache> registry = new ArrayList<>(Collections.emptyList());

  public static HolidayCache getOrCreateForCountry(IsKnownCountry country) {
    Optional<HolidayCache> found = getByCountry(country);

    if (found.isPresent()) {
      return found.get();
    } else {
      HolidayCache newCache = HolidayCache.create(country);
      registry.add(newCache);
      return newCache;
    }
  }

  private static Optional<HolidayCache> getByCountry(IsKnownCountry country) {
    return registry.stream()
            .filter(hc -> hc.country().name().equals(country.name()))
            .findFirst();
  }
}
