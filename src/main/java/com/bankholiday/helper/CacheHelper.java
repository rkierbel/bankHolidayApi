package com.bankholiday.helper;

import com.bankholiday.country.IsKnownCountry;
import com.bankholiday.holiday.IsKnownHoliday;

import java.util.Map;
import java.util.Set;

public class CacheHelper {

  IsKnownCountry country;
  Map<Integer, Set<IsKnownHoliday>> holidaysPerYear;
}
