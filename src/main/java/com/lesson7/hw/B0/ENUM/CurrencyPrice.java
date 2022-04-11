package com.lesson7.hw.B0.ENUM;

public enum CurrencyPrice {
    USD ("USD"),
    UAH ("UAH"),
    EURO ("EURO");

    public static final CurrencyPrice[] ALL = { USD, UAH, EURO };

    private final String name;

    public static CurrencyPrice forName(final String name) {
        if (name.toUpperCase().equals("USD"))
            return USD;
         else if (name.toUpperCase().equals("UAH"))
            return UAH;
        else if (name.toUpperCase().equals("EURO"))
            return EURO;
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Feature");
    }

    private CurrencyPrice(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
