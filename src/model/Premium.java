package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Premium extends Reader{

    public Premium(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>();
        magazines = new ArrayList<>();
    }
    @Override
    public String addBook(Book book){

        books.add(book);
        Calendar calendarTime = Calendar.getInstance();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());
        String msg = "Confirmation ticket: \n The Book has been added in the Date: "+ timeStamp + " \nThe product value is $" + book.getValueProduct() ;
        return msg;
    }
    @Override
    public String addMagazine(Magazine magazine){

        magazines.add(magazine);
        Calendar calendarTime = Calendar.getInstance();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

        String msg = "Confirmation ticket: \n The magazine has been added in the Date: "+ timeStamp + " and the product value is $" + magazine.getValueProduct() ;
        return msg;

    }
}
