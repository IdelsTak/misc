package com.vlado.strings;

/**
 * Format a string of numbers to display a currency - example" "1234.678" to "1,234.68"
 */
public class FormatCurrency {

  private final String sign;

  public static void main(String[] args) {
    System.out.println(new FormatCurrency("$").format("1234.678"));
  }

  public FormatCurrency(String sign) {
    this.sign = sign;
  }

  public String format(String number) {
    int separatorIndex = number.indexOf(".");
    String wholePart = number.substring(0, separatorIndex);
    String decimalPart = number.substring(separatorIndex + 1, number.length());

    return String.format("%s%s.%s", sign, addCommas(wholePart), round(decimalPart));
  }

  private String addCommas(String wholePart) {
    StringBuilder sb = new StringBuilder();
    int counter = 1;
    for (int i = wholePart.length() - 1; i >= 0 ; i--) {
      sb.append(wholePart.charAt(i));
      if (counter == 3) {
        sb.append(",");
        counter = 0;
      }
      counter ++;
    }
    return sb.reverse().toString();
  }

  private String round(String decimal) {
    if (decimal.length() > 2 ) {
        return new String(new char[]{decimal.charAt(0), decimal.charAt(1)});
    }
    return decimal;
  }
}
