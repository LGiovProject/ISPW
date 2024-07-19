package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.TypeOfOpportunity;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.TypeOfOpportunityNotFound;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.exception.WrongDataInsertException;
import com.mysql.cj.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class RegistrationOpportunityBean {

    private int id;
    private String title;
    private String email;
    private String nameBookShop;
    private TypeOfOpportunity typeOfOppportunity;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public RegistrationOpportunityBean(){}

    public RegistrationOpportunityBean(int id, String title, TypeOfOpportunity typeOfOppportunity, String description, LocalDate dateStart, LocalDate dateFinish) {
        this.id = id;
        this.title = title;
        this.typeOfOppportunity = typeOfOppportunity;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws TitleCampRequiredException {
        if(title.isEmpty() || title.isBlank())
            throw new TitleCampRequiredException();
        else
            this.title=title;
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

    public void setTypeOfOpportunity(int typeOfOpportunity) throws TypeOfOpportunityNotFound {

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
            default: throw new TypeOfOpportunityNotFound();
        }
    }

    public void setTypeOfOpportunity(String typeOfOpportunity) throws TypeOfOpportunityNotFound {
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
            default: throw new TypeOfOpportunityNotFound();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateStartString() {
        return dateStart.format(dateTimeFormatter);
    }

    public LocalDate getDateStart(){ return dateStart;}

    public void setDateStart(LocalDate dateStart) throws WrongDataInsertException {
        if (dateStart.isBefore(LocalDate.now()))
            throw new WrongDataInsertException("Start date can't be earlier than"+LocalDate.now().format(dateTimeFormatter));
        this.dateStart=dateStart;
    }

    public void setDateStart(String dateStart) throws WrongDataFormatException, WrongDataInsertException {

        String pattern="\\d{4}-\\d{2}-\\d{2}";
        LocalDate bufferStart = StringUtils.isEmptyOrWhitespaceOnly(dateStart)?null:LocalDate.parse(dateStart);
        if(bufferStart==null || !Pattern.matches(pattern,dateStart))
            throw new WrongDataFormatException();
        else {
            if (bufferStart.isBefore(LocalDate.now()))
                throw new WrongDataInsertException("Start date can't be earlier than"+LocalDate.now().format(dateTimeFormatter));
            else
                this.dateStart = bufferStart;

        }
    }

    public String getDateFinishString() {
        return dateFinish.format(dateTimeFormatter);
    }

    public LocalDate getDateFinish(){ return dateFinish;}

    public void setDateFinish(LocalDate dateFinish){this.dateFinish= dateFinish;}

    public void setDateFinish(String dateStart, String dateFinish) throws WrongDataInsertException, WrongDataFormatException {

        String pattern="\\d{4}-\\d{2}-\\d{2}";
        LocalDate bufferFinish = StringUtils.isEmptyOrWhitespaceOnly(dateFinish)?null:LocalDate.parse(dateFinish);
        if(bufferFinish == null || !Pattern.matches(pattern,dateFinish))
            throw new WrongDataFormatException();
        else {
            if (bufferFinish.isBefore(LocalDate.parse(dateStart)))
                throw new WrongDataInsertException("Finish date can't be earlier than " + dateStart);
            else
                this.dateFinish = bufferFinish;
        }
    }

    public void setDateFinish(LocalDate dateStart, LocalDate dateFinish) throws WrongDataInsertException {
        if(dateFinish.isBefore(dateStart))
            throw new WrongDataInsertException("Finish date can't be earlier than "+dateStart.format(dateTimeFormatter));
        else
            this.dateFinish = dateStart;
    }

    public void setDateFinish(String dateFinish)
    {
        this.dateFinish = LocalDate.parse(dateFinish);
    }



}
