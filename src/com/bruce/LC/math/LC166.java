package com.bruce.LC.math;

import java.util.HashMap;

public class LC166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || numerator < 0 && denominator > 0) {
            stringBuilder.append("-");
        }
        long longNumerator = Math.abs((long) numerator);
        long longDenominator = Math.abs((long) denominator);
        if (longNumerator % longDenominator == 0) {
            stringBuilder.append(longNumerator / longDenominator);
            return stringBuilder.toString();
        }
        stringBuilder.append(longNumerator / longDenominator).append(".");
        StringBuilder fractionPart = getFractionPart(longNumerator, longDenominator);
        return stringBuilder.append(fractionPart).toString();

    }


    private StringBuilder getFractionPart(long longNumerator, long longDenominator) {
        long remainder = longNumerator % longDenominator;
        HashMap<Long, Integer> map = new HashMap<>();
        Integer index = 0;
        StringBuilder fractionPart = new StringBuilder();

        while (remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, index);
            index++;
            long value = remainder * 10 / longDenominator;
            fractionPart.append(value);
            remainder = remainder * 10 % longDenominator;
        }

        if (remainder != 0) {
            // the loop number start index
            Integer startIndex = map.get(remainder);
            fractionPart.insert(startIndex, "(");
            fractionPart.append(")");
        }

        return fractionPart;
    }

    public static void main(String[] args) {
        System.out.println(new LC166().fractionToDecimal(-2147483648, 1));
    }
}
