package model;

import java.util.ArrayList;

public class Reader {
    private String nameReader;
    private String idReader;
    protected ArrayList<Book>books;
    protected ArrayList<Magazine>magazines;

    public Reader(String nameReader, String idReadder){
        this.nameReader = nameReader;
        this.idReader = idReadder;

    }
    
}
