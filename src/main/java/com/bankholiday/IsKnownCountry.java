package com.bankholiday;

import java.time.LocalDate;

public interface IsKnownCountry {

  LocalDate date(int year);
  <E extends IsKnownCountry> IsKnownCountry[] values();

}
