package com.ispw.circularbook.engineering.enums;

public enum TypeOfOpportunity {

    ANY(0,"null"), EVENT(1,"Event"), PROMOTION(2,"Promotion");
    private final int id;
    private final String type;
    TypeOfOpportunity(int id, String type)
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
