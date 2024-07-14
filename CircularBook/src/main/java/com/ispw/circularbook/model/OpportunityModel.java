package com.ispw.circularbook.model;

import java.time.LocalDate;

public class OpportunityModel {

    private int id;
    private BookShopModel bookShopModel;
    private String bookShopName;
    private int typeOfOpportunity;
    private String dateStart;
    private String dateFinish;
    private String description;
    private String title;
    private String month;
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookShopModel getBookShopModel() {
        return bookShopModel;
    }

    public void setBookShopModel(BookShopModel bookShopModel) {
        this.bookShopModel = bookShopModel;
    }

    public int getTypeOfOpportunity()
    {
        return typeOfOpportunity;
    }

    public void setTypeOfOpportunity(int typeOfOpportunity) {
        this.typeOfOpportunity = typeOfOpportunity;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public String getDateStartString() {
        return dateStart;
    }

    public LocalDate getDateStart(){

        return LocalDate.parse(dateStart);
    }
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinishString() {
        return dateFinish;
    }

    public LocalDate getDateFinish(){ return LocalDate.parse(dateFinish);}

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMonth(String month)
    {
                this.month=month;
    }

    public String getMonth(){
        return month;
    }
}
