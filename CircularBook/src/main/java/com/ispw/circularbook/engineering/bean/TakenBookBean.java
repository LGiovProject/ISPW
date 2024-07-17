package com.ispw.circularbook.engineering.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TakenBookBean {
    private int id;
    private int typeOfDisponibility;
    private String emailGiver; //chi ha reso disponibile il libro
    private String emailTaker;
    private String dateStart;
    private String dateFinish;
    private int accountTypeGiver;

    public TakenBookBean(int id, int accountTypeGiver, int typeOfDisponibility , String emailGiver, String emailTaker, LocalDate dateStart) {
        this.id = id;
        this.accountTypeGiver = accountTypeGiver;
        this.typeOfDisponibility= typeOfDisponibility;
        this.emailGiver = emailGiver;
        this.emailTaker=emailTaker;

        setDateStart(dateStart);
        setDateFinish();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeOfDisponibility(int typeOfDisponibility){this.typeOfDisponibility=typeOfDisponibility;}

    public int getTypeOfDisponibility() {
        return typeOfDisponibility;
    }

    public String getTypeOfDisponibilityString(){
        return typeOfDisponibility==1?"Prestito":"Regalo";
    }

    public String getEmailGiver() {
        return emailGiver;
    }

    public void setEmailGiver(String emailGiver) {
        this.emailGiver = emailGiver;
    }

    public String getEmailTaker() {
        return emailTaker;
    }

    public void setEmailTaker(String emailTaker) {
        this.emailTaker = emailTaker;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish() {
        LocalDate dateStartTemp = LocalDate.parse(this.dateStart,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dateFinishTemp =dateStartTemp.plusMonths(1);
        this.dateFinish = dateFinishTemp.toString();
    }

    public int getAccountTypeGiver() {
        return accountTypeGiver;
    }

    public void setAccountTypeGiver(int accountTypeGiver) {
        this.accountTypeGiver = accountTypeGiver;
    }
}
