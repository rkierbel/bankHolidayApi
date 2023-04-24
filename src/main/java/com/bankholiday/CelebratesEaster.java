package com.bankholiday;

import java.time.LocalDate;
import java.util.List;

public interface CelebratesEaster {

  static List<LocalDate> easterDependentHolidays(int year) {
    LocalDate whitMonday = calculateEasterSunday(year).plusDays(50);
    LocalDate easterMonday = calculateEasterSunday(year).plusDays(1);
    LocalDate ascension = calculateEasterSunday(year).plusDays(39);
    return List.of(whitMonday, easterMonday, ascension);
  }
  static LocalDate calculateEasterSunday(int currentYear) {
    float locationInMetonicCycle = currentYear % 19;
    float numOfLeapDaysJulianCal = currentYear % 4;
    float numOfLeapDaysNonLeapYear = currentYear % 7;
    float relationOne = (float) Math.floor((float) currentYear / 100);
    float relationTwo = (float) Math.floor((13 + 8 * relationOne) / 25);
    float centuryPlusThree = (15 - relationTwo + relationOne - relationOne / 4) % 30;
    float diffLeapDaysCalendars = (4 + relationOne - relationOne / 4) % 7;
    float fromMarch21stToPaschalFullMoon = (19 * locationInMetonicCycle + centuryPlusThree) % 30;
    float fromPaschalFullMoonToNextSunday = (
            2 * numOfLeapDaysJulianCal + 4 * numOfLeapDaysNonLeapYear +
                    6 * fromMarch21stToPaschalFullMoon + diffLeapDaysCalendars) % 7;
    int days = (int) (22 + fromMarch21stToPaschalFullMoon + fromPaschalFullMoonToNextSunday);

    if (fromMarch21stToPaschalFullMoon == 29 && fromPaschalFullMoonToNextSunday == 6) {
      return LocalDate.of(currentYear, 4, 29);
    } else if (fromMarch21stToPaschalFullMoon == 28 && fromPaschalFullMoonToNextSunday == 6) {
      return LocalDate.of(currentYear, 4, 18);
    } else {
      if (days > 31) {
        int dayOfMonth = days - 31;
        return LocalDate.of(currentYear, 4, dayOfMonth);
      } else {
        return LocalDate.of(currentYear, 3, days);
      }
    }
  }
}
