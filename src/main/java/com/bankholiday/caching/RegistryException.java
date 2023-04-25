package com.bankholiday.caching;

import com.bankholiday.country.IsKnownCountry;

public class RegistryException extends Exception {
  public RegistryException(IsKnownCountry country) {
    super("Error trying to find " + country.name() +
            " in the cache registry : the country provided is not a known country.");
  }
}
