package model;

import java.util.ArrayList;

public class Regular extends Reader{

    public Regular(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>(5);
        magazines = new ArrayList<>(2);
    }


}
