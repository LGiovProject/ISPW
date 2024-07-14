package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.enums.TypeOfBook;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.mysql.cj.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;


public class BookBean {
    private int id;
    private String email;
    private int accountType;
    private String username;
    private TypeOfBook typeOfBook;
    private String title;
    private String author;
    private Arguments argument;
    private String publisher;
    private int nPage;
    private String comment;

    //info book
    private LocalDate dateStart;
    private LocalDate dateFinish;

    private long daysRemain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public TypeOfBook getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(TypeOfBook typeOfBook) {
        this.typeOfBook = typeOfBook;
    }


    public int getTypeOfBookInt() {
        return typeOfBook.getId();
    }

    public void setTypeOfBook(int typeOfBook) {
        for(TypeOfBook type : TypeOfBook.values())
            if (type.getId()==typeOfBook)
                this.typeOfBook=type;
    }

    public String getTypeOfDisponibilityString(){
        return typeOfBook.getId()==1?"Lend":"Gift";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author ==null?"": author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Arguments getArgument(){return argument;}

    public String getArgumentString() {
        return this.argument.getArgument();
    }

    public void setArgument(Arguments argument) {
        this.argument =argument==null?Arguments.ANY :argument;
    }

    public void setArgument(String argument){

            for (Arguments arguments : Arguments.values()) {
                if (arguments.getArgument().equals(argument)) {
                    this.argument = arguments;
                }
            }



    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNPageString() {
        return String.valueOf(nPage);
    }

    public int getNPage(){return nPage;}

    public void setNPage(int nPage)
    {
        this.nPage =nPage;
    }

    public void setNPage(String nPage)
    {
        if(!nPage.isEmpty() || !nPage.isBlank())
            this.nPage = Integer.parseInt(nPage);
        else
            this.nPage = 0;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public String getDateStartString() {
        return dateStart.toString();
    }

    public void setDateStart(LocalDate dateStart){this.dateStart =dateStart;}

    public void setDateStart(String dateStart) throws WrongDataFormatException {
        String pattern="\\d{4}-\\d{2}-\\d{2}";
        if(!Pattern.matches(pattern,dateStart))
            throw new WrongDataFormatException();
        this.dateStart= StringUtils.isEmptyOrWhitespaceOnly(dateStart)?null:LocalDate.parse(dateStart);
    }

    public LocalDate getDateFinish(){
        return dateFinish;
    }

    public String getDateFinishString() {
        return dateFinish.toString();
    }

    public void setDateFinish(String dateFinish) throws WrongDataFormatException {

        String pattern="\\d{4}-\\d{2}-\\d{2}";
        if(!Pattern.matches(pattern,dateFinish))
            throw new WrongDataFormatException();
        this.dateFinish= StringUtils.isEmptyOrWhitespaceOnly(dateFinish)?null:LocalDate.parse(dateFinish);
    }

    public void setDateFinish(LocalDate dateFinish){this.dateFinish=dateFinish;}

    public long getDaysRemain()
    {
        return this.daysRemain;
    }

    public void setDaysRemain(String dateFinish)
    {

        LocalDate nowDate = LocalDate.now();
        LocalDate finishDate = LocalDate.parse(dateFinish);
        Period period = Period.between(nowDate, finishDate);
        this.daysRemain = period.getDays();


    }
    public void setDaysRemain(long daysRemain){ this.daysRemain =daysRemain;}

}
