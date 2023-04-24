package com.bankholiday;

import java.time.LocalDate;

interface IsKnownHoliday {

  LocalDate date(int year);
  IsKnownHoliday[] values();

}
