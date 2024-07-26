package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.enums.TypeOfBook;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;

public class RegistrationBookBean {
    String email;
    TypeOfBook typeOfBook;
    boolean user;
    String publisher;
    String title;
    String author;
    Arguments argument;
    String nPage;
    String comment;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean aUser) {
        this.user = aUser;
    }

    public void setAUser(int aUser){this.user = (aUser == 1);}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws TitleCampRequiredException {
        if(title.isBlank() || title.isEmpty())
            throw new TitleCampRequiredException();
        else
        {
            this.title= title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.isEmpty() || author.isBlank())
            this.author = "None";
        else
            this.author= author;
    }

    public String getArgument() {
        return argument.getArgument();
    }

    public void setArgument(Arguments argument) {
            this.argument=argument;
    }

    public void setArgument(String argument) throws WrongArgumentInsertException {
        if(argument.isEmpty() || argument.isBlank())
            this.argument=Arguments.NONE;
        else {
            for (Arguments arguments : Arguments.values()) {
                if (arguments.getArgument().equals(argument)) {
                    this.argument = arguments;
                }
            }
            if(this.argument==null)
                throw new WrongArgumentInsertException();
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher.isEmpty() || publisher.isBlank())
            this.publisher="None";
        else
            this.publisher=publisher;
    }

    public String getNPage() {
        return this.nPage;
    }

    public int getNPageInt(){
        return Integer.parseInt(this.nPage);
    }

    public void setNPage(String nPage) throws WrongNpageFormatException {
        if(nPage.isEmpty() || nPage.isBlank())
            this.nPage ="0";
        else
            if(nPage.matches("^\\d+$"))
                this.nPage=nPage;
            else
                throw new WrongNpageFormatException();
    }

    public void setNPage(int nPage)
    {
        this.nPage=String.valueOf(nPage);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment.isBlank()|| comment.isEmpty())
            this.comment = "no comment";
        else
            this.comment=comment;
    }
}
