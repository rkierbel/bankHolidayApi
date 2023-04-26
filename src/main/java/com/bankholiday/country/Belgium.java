package com.bankholiday.country;

import com.bankholiday.holiday.CelebratesEaster;
import com.bankholiday.holiday.IsKnownHoliday;
import com.bankholiday.holiday.percountry.BelgianHoliday;

public class Belgium implements IsKnownCountry, CelebratesEaster {

  private static final Belgium instance = new Belgium();

  private Belgium() {
  }

  public static Belgium instance() {
    return instance;
  }

  @Override
  public String name() {
    return "BELGIUM";
  }

  @Override
  public IsKnownHoliday[] holidays() {
    return BelgianHoliday.values();
  }
}
