package com.ispw.circularbook.engineering.enums;

public enum Month {
    CERCA_IN_TUTTI_I_MESI(0,"null"), JANUARY(1,"January"), FEBRUARY(2,"February"), MARCH(3,"March"), APRIL(4,"April"), MAY(5,"May"), JUNE(6,"June"), JULY(7,"July"), AUGUST(8,"August"), SEPTEMBER(9,"September"), OCTOBER(10,"October"), NOVEMBER(11,"November"), DECEMBER(12,"December");
    private final int id;
    private final String months;
    Month(int id,String months)
    {
        this.id=id;
        this.months = months;
    }

    public int getId()
    {
        return id;
    }
    public String getMonths()
    {
        return months;
    }

}


