package com.bankholiday.country;

import com.bankholiday.holiday.IsKnownHoliday;

public interface IsKnownCountry {

  String name();

  IsKnownHoliday holidays();
}
