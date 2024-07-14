package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;


public class SearchBookBean {

   private String email;
   private String author;
   private String argument;
   private String title;

    public SearchBookBean(String email) {
        setEmail(email);
    }

    public SearchBookBean(String author, Arguments argument, String title, String email) {
       setAuthor(author);
       setArgument(argument);
       setTitle(title);
       setEmail(email);
   }

    public SearchBookBean(String author, String argument, String title,String email) throws WrongArgumentInsertException {
        setAuthor(author);
        setArgument(argument);
        setTitle(title);
        setEmail(email);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

       if (author.isBlank() || author.isEmpty())
           this.author="null";
       else
           this.author="'"+author+"'";

    }

    public String getArgument() {

        return this.argument;

    }

    public void setArgument(String argument) throws WrongArgumentInsertException {

        if(argument.isEmpty() || argument.isBlank())
            this.argument = Arguments.ANY.getArgument();
        else {
            checkArgument(argument);
            this.argument = "'"+argument+"'";
        }
    }

    public void setArgument(Arguments argument) {
        this.argument=argument.getArgument();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if(title.isBlank() || title.isEmpty())
            this.title="null";
        else
            this.title="'"+title+"'";

    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email="'"+email+"'";
    }

    private void checkArgument(String argument) throws WrongArgumentInsertException {
        boolean flag=false;
        for (Arguments arguments : Arguments.values())
            if (arguments.getArgument().equals(argument))
                flag=true;
        if(!flag)
            throw new WrongArgumentInsertException();
    }


}
