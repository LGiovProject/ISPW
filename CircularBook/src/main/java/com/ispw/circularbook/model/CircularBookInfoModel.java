package com.ispw.circularbook.model;

public class CircularBookInfoModel {



    int registerBook;
    int lendedBook;
    int giftedBook;
    int lendedBookTaked;
    int giftedBooktaked;
    int opportunityInsert;

    public CircularBookInfoModel(){}

    public CircularBookInfoModel(int registerBook, int lendedBook, int giftedBook, int opportunityInsert) {
        this.registerBook = registerBook;
        this.lendedBook = lendedBook;
        this.giftedBook= giftedBook;
        this.opportunityInsert = opportunityInsert;
    }

    public CircularBookInfoModel(int registerBook, int lendedBook, int giftedBook, int lendedBookTaked, int giftedBooktaked) {
        this.registerBook = registerBook;
        this.lendedBook = lendedBook;
        this.giftedBook = giftedBook;
        this.lendedBookTaked = lendedBookTaked;
        this.giftedBooktaked = giftedBooktaked;
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
