package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.mysql.cj.util.StringUtils;

public class SearchOpportunityBean {
    private Month month;
    private String nameLib;
    private TypeOfOpportunity typeOfOpportunity;

    public SearchOpportunityBean(String nameLib, Month month, TypeOfOpportunity typeOfOpportunity) {
        setNameLib(nameLib);
        setTypeOfOpportunity(typeOfOpportunity);
        setMonth(month);
    }

    public SearchOpportunityBean(String nameLib, String month, String typeOfOpportunity) {
        setNameLib(nameLib);
        setTypeOfOpportunity(typeOfOpportunity);
        setMonth(month);
    }


    public Integer getMonth() {
            return this.month.getId();
    }

    public String getMonthString()
    {
        return this.month.getMonths();
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setMonth(String month){
        this.month=Month.CERCA_IN_TUTTI_I_MESI;
        for(Month month1: Month.values()) {
            if (month1.getMonths().equals(month)) {
                this.month = month1;
                break;
            }
        }

    }

    public String getNameLib() {

       return this.nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = checkNameLib(nameLib);
    }

    public Integer getTypeOfOpportunity() {
            return this.typeOfOpportunity.getId();
    }

    public void setTypeOfOpportunity(TypeOfOpportunity typeOfOpportunity) {
        this.typeOfOpportunity = typeOfOpportunity;
    }

    public String getTypeOfOpportunityString(){return typeOfOpportunity.getType();}
    public void setTypeOfOpportunity(String typeOfOpportunity)
    {
        if(TypeOfOpportunity.EVENT.getType().equals(typeOfOpportunity))
            this.typeOfOpportunity = TypeOfOpportunity.EVENT;
        else if (TypeOfOpportunity.PROMOTION.getType().equals(typeOfOpportunity))
            this.typeOfOpportunity = TypeOfOpportunity.PROMOTION;
        else
            this.typeOfOpportunity = TypeOfOpportunity.ANY;
    }

    private String checkNameLib(String nameLib)
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(nameLib))
            return null;
        else
            return "'"+nameLib+"'";
    }
}
