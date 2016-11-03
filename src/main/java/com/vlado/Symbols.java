package com.vlado;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class Symbols {

    public static void main(String[] args) {
        String[] chemicals = new String[] { "Amazon", "Microsoft", "Google" };
        String[] symbols = new String[] { "I", "Am", "cro", "Na", "le", "abc" };

        for (String chemical : chemicals) {
            String selectedSymbol = "";
            for (String symbol : symbols) {
                if (chemical.toLowerCase().contains(symbol.toLowerCase())
                        && symbol.length() > selectedSymbol.length()) {
                    selectedSymbol = symbol;
                }
            }
            System.out.println(chemical.replaceFirst(selectedSymbol, "[" + selectedSymbol + "]"));
        }
    }
}
