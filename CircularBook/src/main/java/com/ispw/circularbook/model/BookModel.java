package com.ispw.circularbook.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class BookModel {
    private int id;
    private int typeOfDisponibility;
    private String title;
    private String author;
    private String arguments;
    private String publisher;
    private int nPage;
    private String comment;



    private GenericAccountModel genericAccountModelPutter;
    private int accountTypePutter;
    private UserModel userModelTaker;



    //info book
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private long daysRemains;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GenericAccountModel getGenericAccountModelPutter() {
        return genericAccountModelPutter;
    }

    public void setGenericAccountModelPutter(GenericAccountModel genericAccountModelPutter) {
        this.genericAccountModelPutter = genericAccountModelPutter;
    }

    public int getAccountTypePutter() {
        return accountTypePutter;
    }

    public void setAccountTypePutter(int accountTypePutter) {
        this.accountTypePutter = accountTypePutter;
    }

    public int getTypeOfDisponibility() { return typeOfDisponibility; }

    public void setTypeOfDisponibility(int typeOfDisponibility) { this.typeOfDisponibility = typeOfDisponibility; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String argument) {

        this.arguments =argument;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNPage() {
        return nPage;
    }

    public void setNPage(int nPagine) {
        this.nPage = nPagine;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String commento) {
        this.comment = commento;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateStart(String dateStart)
    {
        this.dateStart = LocalDate.parse(dateStart,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setDateFinish(String dateFinish){
        this.dateFinish = LocalDate.parse(dateFinish,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public UserModel getUserModelTaker() {
        return userModelTaker;
    }

    public void setUserModelTaker(UserModel userModelTaker) {
        this.userModelTaker = userModelTaker;
    }

    public void setDaysRemains(long daysRemains)
    {
        this.daysRemains = daysRemains;
    }

    public void setDaysRemaing(String dateFinish)
    {

        LocalDate nowDate = LocalDate.now();
        LocalDate finishDate = LocalDate.parse(dateFinish);
        this.daysRemains=nowDate.until(finishDate, ChronoUnit.DAYS);

    }

    public long getDaysRemains()
    {
        return this.daysRemains;
    }
}
