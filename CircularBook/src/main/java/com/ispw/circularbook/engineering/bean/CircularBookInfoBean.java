package com.ispw.circularbook.engineering.bean;

public class CircularBookInfoBean {

    private String username;
    private String email;

    private int registerBook;
    private int lendedBook;
    private int giftedBook;
    private int lendedBookTaked;
    private int giftedBooktaked;
    private int opportunityInsert;

    public CircularBookInfoBean(){}

    public CircularBookInfoBean(String email) {
        this.email = email;
    }

    public CircularBookInfoBean(int registerBook, int lendedBook, int giftedBook, int opportunityInsert) {
        this.registerBook = registerBook;
        this.lendedBook = lendedBook;
        this.giftedBook= giftedBook;
        this.opportunityInsert = opportunityInsert;
    }

    public CircularBookInfoBean(int registerBook, int lendedBook, int giftedBook, int lendedBookTaked, int giftedBooktaked) {
        this.registerBook = registerBook;
        this.lendedBook = lendedBook;
        this.giftedBook = giftedBook;
        this.lendedBookTaked = lendedBookTaked;
        this.giftedBooktaked = giftedBooktaked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRegisterBook() {
        return registerBook;
    }

    public void setRegisterBook(int registerBook) {
        this.registerBook = registerBook;
    }

    public int getLendedBook() {
        return lendedBook;
    }

    public void setLendedBook(int lendedBook) {
        this.lendedBook = lendedBook;
    }

    public int getGiftedBook() {
        return giftedBook;
    }

    public void setGiftedBook(int giftedBook) {
        this.giftedBook = giftedBook;
    }

    public int getLendedBookTaked() {
        return lendedBookTaked;
    }

    public void setLendedBookTaked(int lendedBookTaked) {
        this.lendedBookTaked = lendedBookTaked;
    }

    public int getGiftedBooktaked() {
        return giftedBooktaked;
    }

    public void setGiftedBooktaked(int giftedBooktaked) {
        this.giftedBooktaked = giftedBooktaked;
    }

    public int getOpportunityInsert() {
        return opportunityInsert;
    }

    public void setOpportunityInsert(int opportunityInsert) {
        this.opportunityInsert = opportunityInsert;
    }
}
