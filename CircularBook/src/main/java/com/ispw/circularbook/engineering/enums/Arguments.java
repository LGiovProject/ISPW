package com.ispw.circularbook.engineering.enums;

public enum Arguments {
    ANY("null"), NONE("None"), HISTORICAL("Historical"), BIOGRAPHY("Biography"), AUTO_BIOGRAPHY("Auto Biography"), THRILLER("Thriller"), ADVENTURE("Adventure"), ACTION("Action"), SCIENCE_FICTION("Science Fiction"), FANTASY("Fantasy"), HORROR("Horror"), ROMANCE("Romance"), COMIC_BOOK("Comic"), OTHER("Other");

    private final String argument;
    Arguments(String argument)
    {
        this.argument=argument;
    }

    public String getArgument()
    {
        return argument;
    }

}