package com.cagatayyapici.luhn;

import java.math.BigInteger;

/**
 * no String * memory friendly implementation
 * 
 * @author cagatayyapici
 *
 */
public class LuhnCheck {
  public static boolean Check(BigInteger num1) {
    int sum = 0;
    long value = num1.longValueExact();
    int digitIdx = 0;
    long digit;
    do {
      digit = value % 10;
      if ((++digitIdx & 1) == 0) {
        long temp = (digit <<= 1 % 10);
        digit = digit <= 9 ? temp : ++temp;
      }
      sum += digit;
    } while ((value /= 10) > 0);
    return (sum % 10 == 0);
  }

}
