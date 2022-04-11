package com.lesson7.hw.B0.ENUM;

public enum Sex {
    MAN ("MAN"),
    WOMAN ("WOMAN");

    public static final Sex[] ALL = { MAN, WOMAN };

    private final String name;

    public static Sex forName(final String name) {
        if (name.toUpperCase().equals("MAN")) {
            return MAN;
        } else if (name.toUpperCase().equals("WOMAN")) {
            return WOMAN;
        }
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Feature");
    }

    private Sex(final String name) {
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
