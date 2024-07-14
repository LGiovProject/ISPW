package com.ispw.circularbook.engineering.enums;

public enum TypeOfBook {
    ANY(0,"null"), LEND(1,"Lend") , GIFT(2,"Gift");

    private final int id;
    private final String type;

    TypeOfBook(int id, String type)
    {
        this.id=id;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
