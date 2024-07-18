package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OpportunityBean {

    private int id;
    private String title;
    private String email;
    private String nameBookShop;
    private TypeOfOpportunity typeOfOppportunity;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameBookShop() {
        return nameBookShop;
    }

    public void setNameBookShop(String nameBookShop) {
        this.nameBookShop = nameBookShop;
    }

    public TypeOfOpportunity getTypeOfOppportunity() {
        return typeOfOppportunity;
    }

    public int getTypeOfOpportunityInt()
    {
        return typeOfOppportunity.getId();
    }


    public String getTypeOfOpportunityString()
    {
        return typeOfOppportunity.getType();
    }

    public void setTypeOfOpportunity(TypeOfOpportunity typeOfOpportunity) {
        this.typeOfOppportunity = typeOfOpportunity;
    }

    public void setTypeOfOpportunity(int typeOfOpportunity) {

        switch (typeOfOpportunity)
        {
            case 1:
            {
                this.typeOfOppportunity = TypeOfOpportunity.EVENT;
                break;
            }
            case 2:
            {
                this.typeOfOppportunity = TypeOfOpportunity.PROMOTION;
                break;

            }
            default: this.typeOfOppportunity = TypeOfOpportunity.ANY;
        }
    }

    public void setTypeOfOpportunity(String typeOfOpportunity) {
        switch (typeOfOpportunity)
        {
            case "Event":
            {
                this.typeOfOppportunity = TypeOfOpportunity.EVENT;
                break;
            }
            case "Promotion":
            {
                this.typeOfOppportunity = TypeOfOpportunity.PROMOTION;
                break;
            }
            default: this.typeOfOppportunity = TypeOfOpportunity.ANY;
        }
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public String getDateStartString()
    {
        return dateStart.format(dateTimeFormatter);
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateStart(String dateStart)
    {
        this.dateStart = LocalDate.parse(dateStart);
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public String getDateFinishString()
    {
        return dateFinish.format(dateTimeFormatter);
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setDateFinish(String dateFinish)
    {
        this.dateFinish = LocalDate.parse(dateFinish);
    }
}
