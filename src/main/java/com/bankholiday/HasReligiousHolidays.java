package com.bankholiday;

import java.time.LocalDate;
import java.util.Set;

public interface HasReligiousHolidays {

  Set<LocalDate> religiousHolidays(int year);

}
