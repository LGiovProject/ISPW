package com.ispw.circularbook.engineering.bean;

import javafx.scene.layout.Pane;

public class ElementBean {

    private Pane pane;
    private int id;

    private OpportunityBean opportunityBean;
    private BookBean bookBean;

    public ElementBean(Pane pane,BookBean bookBean) {
        this.pane = pane;

        this.bookBean=bookBean;
    }

    public ElementBean(Pane pane, OpportunityBean opportunityBean) {
        this.pane = pane;

        this.opportunityBean = opportunityBean;
    }

    public ElementBean(Pane pane, int id) {
        this.pane = pane;
        this.id = id;
    }

    public ElementBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }

    public ElementBean(int id) {
        this.id = id;
    }

    public ElementBean(OpportunityBean opportunityBean)
    {
        this.opportunityBean = opportunityBean;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }

    public OpportunityBean getOpportunityBean() {
        return opportunityBean;
    }

    public void setOpportunityBean(OpportunityBean opportunityBean) {
        this.opportunityBean = opportunityBean;
    }
}
