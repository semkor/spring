package com.lesson7.hw.B0.ENUM;

public enum Subcategory {
    SALE  ("SALE"),
    PURCHASE ("PURCHASE");

    public static final Subcategory[] ALL = { SALE, PURCHASE };

    private final String name;

    public static Subcategory forName(final String name) {
        if (name.toUpperCase().equals("SALE"))
            return SALE;
        else if (name.toUpperCase().equals("PURCHASE"))
            return PURCHASE;
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Subcategory");
    }

    private Subcategory(final String name) {
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
