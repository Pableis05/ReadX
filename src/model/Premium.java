package model;

import java.util.ArrayList;

public class Premium extends Reader{

    public Premium(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>();
        magazines = new ArrayList<>();
    }
}
