package com.bankholiday.holiday.typology;

import java.time.LocalDate;
import java.util.Set;

public interface HasReligiousHolidays {

  Set<LocalDate> religiousHolidays(int year);

}
